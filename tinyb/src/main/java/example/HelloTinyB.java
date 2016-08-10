package example;

import std.*;
import tinyb.*;

public class HelloTinyB {

    static {
        NativeLoader.load();
    }

    private static final float SCALE_LSB = 0.03125f;
    static boolean running = true;

    static void printDevice(BluetoothDevice device) {
        System.out.print("Address = " + device.get_address().getString());
        System.out.print(" Name = " + device.get_name().getString());
        System.out.print(" Connected = " + device.get_connected());
        System.out.println();
    }

    static float convertCelsius(int raw) {
        return raw / 128f;
    }

    /*
     * After discovery is started, new devices will be detected. We can get a list of all devices through the manager's
     * getDevices method. We can the look through the list of devices to find the device with the MAC which we provided
     * as a parameter. We continue looking until we find it, or we try 15 times (1 minutes).
     */
    static BluetoothDevice getDevice(String address) throws InterruptedException {
        BluetoothManager manager = BluetoothManagerImpl.get_bluetooth_manager();
        BluetoothDevice sensor = null;
        for (int i = 0; (i < 15) && running; ++i) {
            UniquePtr_Vector<UniquePtr<BluetoothDevice>> devices = manager.get_devices();

            for (int j = 0; j < devices.size(); j++) {
                BluetoothDevice device = devices.get(j).get();
                printDevice(device);
                /*
                 * Here we check if the address matches.
                 */
                if (device.get_address().getString().equals(address))
                    sensor = device;
            }

            if (sensor != null) {
                return sensor;
            }
            Thread.sleep(4000);
        }
        return null;
    }

    /*
     * Our device should expose a temperature service, which has a UUID we can find out from the data sheet. The service
     * description of the SensorTag can be found here:
     * http://processors.wiki.ti.com/images/a/a8/BLE_SensorTag_GATT_Server.pdf. The service we are looking for has the
     * short UUID AA00 which we insert into the TI Base UUID: f000XXXX-0451-4000-b000-000000000000
     */
    static BluetoothGattService getService(BluetoothDevice device, String UUID) throws InterruptedException {
        System.out.println("Services exposed by device:");
        BluetoothGattService tempService = null;
        UniquePtr_Vector<UniquePtr<BluetoothGattService>> bluetoothServices = null;
        do {
            bluetoothServices = device.get_services();

            for (int i = 0; i < bluetoothServices.size(); i++) {
                BluetoothGattService service = bluetoothServices.get(i).get();
                System.out.println("UUID: " + service.get_uuid().getString());
                if (service.get_uuid().getString().equals(UUID))
                    tempService = service;
            }
            Thread.sleep(4000);
        } while (bluetoothServices != null && (bluetoothServices.size() == 0) && running);
        return tempService;
    }

    static BluetoothGattCharacteristic getCharacteristic(BluetoothGattService service, String UUID) {
        UniquePtr_Vector<UniquePtr<BluetoothGattCharacteristic>> characteristics = service.get_characteristics();

        for (int i = 0; i < characteristics.size(); i++) {
            BluetoothGattCharacteristic characteristic = characteristics.get(i).get();
            if (characteristic.get_uuid().getString().equals(UUID))
                return characteristic;
        }
        return null;
    }

    /*
    * This program connects to a TI SensorTag 2.0 and reads the temperature characteristic exposed by the device over
    * Bluetooth Low Energy. The parameter provided to the program should be the MAC address of the device.
    *
    * A wiki describing the sensor is found here: http://processors.wiki.ti.com/index.php/CC2650_SensorTag_User's_Guide
    *
    * The API used in this example is based on TinyB v0.3, which only supports polling, but v0.4 will introduce a
    * simplied API for discovering devices and services.
    */
    public static void main(String[] args) throws InterruptedException {

        if (args.length < 1) {
            System.err.println("Run with <device_address> argument");
            System.exit(-1);
        }

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                running = false;
            }
        });

        /*
         * To start looking of the device, we first must initialize the TinyB library. The way of interacting with the
         * library is through the BluetoothManager. There can be only one BluetoothManager at one time, and the
         * reference to it is obtained through the getBluetoothManager method.
         */
        BluetoothManager manager = BluetoothManagerImpl.get_bluetooth_manager();

        /*
         * The manager will try to initialize a BluetoothAdapter if any adapter is present in the system. To initialize
         * discovery we can call startDiscovery, which will put the default adapter in discovery mode.
         */
        boolean discoveryStarted = manager.start_discovery();

        System.out.println("The discovery started: " + (discoveryStarted ? "true" : "false"));
        BluetoothDevice sensor = getDevice(args[0]);

        /*
         * After we find the device we can stop looking for other devices.
         */
        manager.stop_discovery();

        if (sensor == null) {
            System.err.println("No sensor found with the provided address.");
            if (running) {
                System.exit(-1);
            }
            return;
        }

        System.out.print("Found device: ");
        printDevice(sensor);

        if (sensor.connect())
            System.out.println("Sensor with the provided address connected");
        else {
            System.out.println("Could not connect device.");
            if (running) {
                System.exit(-1);
            }
            return;
        }

        BluetoothGattService tempService = getService(sensor, "f000aa00-0451-4000-b000-000000000000");

        if (tempService == null) {
            System.err.println("This device does not have the temperature service we are looking for.");
            sensor.disconnect();
            if (running) {
                System.exit(-1);
            }
            return;
        }
        System.out.println("Found service " + tempService.get_uuid().getString());

        BluetoothGattCharacteristic tempValue = getCharacteristic(tempService, "f000aa01-0451-4000-b000-000000000000");
        BluetoothGattCharacteristic tempConfig = getCharacteristic(tempService, "f000aa02-0451-4000-b000-000000000000");
        BluetoothGattCharacteristic tempPeriod = getCharacteristic(tempService, "f000aa03-0451-4000-b000-000000000000");

        if (tempValue == null || tempConfig == null || tempPeriod == null) {
            System.err.println("Could not find the correct characteristics.");
            sensor.disconnect();
            if (running) {
                System.exit(-1);
            }
            return;
        }

        System.out.println("Found the temperature characteristics");

        /*
         * Turn on the Temperature Service by writing 1 in the configuration characteristic, as mentioned in the PDF
         * mentioned above. We could also modify the update interval, by writing in the period characteristic, but the
         * default 1s is good enough for our purposes.
         */
        byte c = 0x01;
        UChar_Vector config = UChar_Vector.create();
        config.push_back(c);
        tempConfig.write_value(config);

        /*
         * Each second read the value characteristic and display it in a human readable format.
         */
        while (running) {
            UChar_Vector tempRaw = tempValue.read_value();
            System.out.print("Temp raw = {");
            for (int i = 0; i < tempRaw.size(); i++) {
                byte b = tempRaw.get(i);
                System.out.print(String.format("%02x,", b));
            }
            System.out.print("}");

            /*
             * The temperature service returns the data in an encoded format which can be found in the wiki. Convert the
             * raw temperature format to celsius and print it. Conversion for object temperature depends on ambient
             * according to wiki, but assume result is good enough for our purposes without conversion.
             */
            int objectTempRaw = tempRaw.get(0) + (tempRaw.get(1) << 8);
            int ambientTempRaw = tempRaw.get(2) + (tempRaw.get(3) << 8);

            float objectTempCelsius = convertCelsius(objectTempRaw);
            float ambientTempCelsius = convertCelsius(ambientTempRaw);

            System.out.println(
                    String.format(" Temp: Object = %fC, Ambient = %fC", objectTempCelsius, ambientTempCelsius));

            Thread.sleep(1000);
        }
        sensor.disconnect();
    }
}
