package tinyb;

import org.moe.natj.cxx.CxxExpectedGeneratedCodeException;
import org.moe.natj.cxx.ann.*;
import std.StdString;
import std.UniquePtr_Vector;
import std.UniquePtr;
import std.Vector;

@CxxHeader(value = {"tinyb/BluetoothDevice.hpp"}, useQuotes = false)
@CxxClass("tinyb::BluetoothDevice")
@CxxDefaultConstructorUnavailable
public interface BluetoothDevice extends BluetoothObject {

    @CxxConstructor
    public static UniquePtr<BluetoothDevice> create(BluetoothDevice bluetoothDevice) {
        throw new CxxExpectedGeneratedCodeException();
    }

    /* D-Bus method calls: */

    /**
     * The connection to this device is removed, removing all connected
     * profiles.
     *
     * @return TRUE if the device disconnected
     */
    @CxxMethod
    public boolean disconnect();

    /**
     * A connection to this device is established, connecting each profile
     * flagged as auto-connectable.
     *
     * @return TRUE if the device connected
     */
    @CxxMethod
    public boolean connect();

    /**
     * Connects a specific profile available on the device, given by UUID
     *
     * @param arg_UUID The UUID of the profile to be connected
     * @return TRUE if the profile connected successfully
     */
    @CxxMethod
    public boolean connect_profile(
            @CxxConst @CxxByReference StdString arg_UUID
    );

    /**
     * Disconnects a specific profile available on the device, given by UUID
     *
     * @param arg_UUID The UUID of the profile to be disconnected
     * @return TRUE if the profile disconnected successfully
     */
    @CxxMethod
    public boolean disconnect_profile(
            @CxxConst @CxxByReference StdString arg_UUID
    );

    /**
     * A connection to this device is established, and the device is then
     * paired.
     *
     * @return TRUE if the device connected and paired
     */
    @CxxMethod
    public boolean pair(
    );

    /**
     * Cancels an initiated pairing operation
     *
     * @return TRUE if the paring is cancelled successfully
     */
    @CxxMethod
    public boolean cancel_pairing(
    );

    /**
     * Returns a list of BluetoothGattServices available on this device.
     *
     * @return A list of BluetoothGattServices available on this device,
     * NULL if an error occurred
     */
    @CxxMethod
    @CxxByValue
    public UniquePtr_Vector<UniquePtr<BluetoothGattService>> get_services(
    );

    /* D-Bus property accessors: */

    /**
     * Returns the hardware address of this device.
     *
     * @return The hardware address of this device.
     */
    @CxxMethod
    @CxxByValue
    public StdString get_address();

    /**
     * Returns the remote friendly name of this device.
     *
     * @return The remote friendly name of this device, or NULL if not set.
     */
    @CxxMethod
    @CxxByValue
    public StdString get_name();

    /**
     * Returns an alternative friendly name of this device.
     *
     * @return The alternative friendly name of this device, or NULL if not set.
     */
    @CxxMethod
    @CxxByValue
    public StdString get_alias();

    /**
     * Sets an alternative friendly name of this device.
     */
    @CxxMethod
    public void set_alias(@CxxConst @CxxByReference StdString value);

    /**
     * Returns the Bluetooth class of the device.
     *
     * @return The Bluetooth class of the device.
     */
    @CxxMethod
    public int get_class();

    /**
     * Returns the appearance of the device, as found by GAP service.
     *
     * @return The appearance of the device, as found by GAP service.
     */
    @CxxMethod
    public int get_appearance();

    /**
     * Returns the proposed icon name of the device.
     *
     * @return The proposed icon name, or NULL if not set.
     */
    @CxxMethod
    @CxxByValue
    public StdString get_icon();

    /**
     * Returns the paired state the device.
     *
     * @return The paired state of the device.
     */
    @CxxMethod
    public boolean get_paired();

    /**
     * Returns the trusted state the device.
     *
     * @return The trusted state of the device.
     */
    @CxxMethod
    public boolean get_trusted();

    /**
     * Sets the trusted state the device.
     */
    @CxxMethod
    public void set_trusted(boolean value);

    /**
     * Returns the blocked state the device.
     *
     * @return The blocked state of the device.
     */
    @CxxMethod
    public boolean get_blocked();

    /**
     * Sets the blocked state the device.
     */
    @CxxMethod
    public void set_blocked(boolean value);

    /**
     * Returns if device uses only pre-Bluetooth 2.1 pairing mechanism.
     *
     * @return True if device uses only pre-Bluetooth 2.1 pairing mechanism.
     */
    @CxxMethod
    public boolean get_legacy_pairing();

    /**
     * Returns the Received Signal Strength Indicator of the device.
     *
     * @return The Received Signal Strength Indicator of the device.
     */
    @CxxMethod
    public int get_rssi();

    /**
     * Returns the connected state of the device.
     *
     * @return The connected state of the device.
     */
    @CxxMethod
    public boolean get_connected();

    /**
     * Returns the UUIDs of the device.
     *
     * @return Array containing the UUIDs of the device, ends with NULL.
     */
    @CxxMethod
    @CxxByValue
    public Vector<StdString> get_uuids();

    /**
     * Returns the local ID of the adapter.
     *
     * @return The local ID of the adapter.
     */
    @CxxMethod
    @CxxByValue
    public StdString get_modalias();

    /**
     * Returns the adapter on which this device was discovered or
     * connected.
     *
     * @return The adapter.
     */
    @CxxMethod
    @CxxByValue
    public BluetoothAdapter get_adapter();
}
