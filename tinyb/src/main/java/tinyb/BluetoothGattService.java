package tinyb;

import org.moe.natj.cxx.CxxExpectedGeneratedCodeException;
import org.moe.natj.cxx.ann.*;
import std.StdString;
import std.UniquePtr_Vector;
import std.UniquePtr;

@CxxHeader(value = {"tinyb/BluetoothGattService.hpp"}, useQuotes = false)
@CxxClass("tinyb::BluetoothGattService")
@CxxDefaultConstructorUnavailable
public interface BluetoothGattService extends BluetoothObject {

    @CxxConstructor
    public static UniquePtr<BluetoothGattService> create(BluetoothGattService bluetoothGattService) {
        throw new CxxExpectedGeneratedCodeException();
    }

    /* D-Bus property accessors: */

    /**
     * Get the UUID of this service
     *
     * @return The 128 byte UUID of this service, NULL if an error occurred
     */
    @CxxMethod
    @CxxByValue
    public StdString get_uuid();

    /**
     * Returns the device to which this service belongs to.
     *
     * @return The device.
     */
    @CxxMethod
    @CxxByValue
    public BluetoothDevice get_device();

    /**
     * Returns true if this service is a primary service, false if secondary.
     *
     * @return true if this service is a primary service, false if secondary.
     */
    @CxxMethod
    public boolean get_primary();

    /**
     * Returns a list of BluetoothGattCharacteristics this service exposes.
     *
     * @return A list of BluetoothGattCharacteristics exposed by this service
     */
    @CxxMethod
    @CxxByValue
    public UniquePtr_Vector<UniquePtr<BluetoothGattCharacteristic>> get_characteristics();
}
