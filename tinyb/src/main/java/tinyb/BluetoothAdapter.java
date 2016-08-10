package tinyb;

import org.moe.natj.cxx.CxxExpectedGeneratedCodeException;
import org.moe.natj.cxx.CxxObject;
import org.moe.natj.cxx.ann.*;
import std.StdString;
import std.UniquePtr_Vector;
import std.UniquePtr;
import std.Vector;

@CxxHeader(value = {"tinyb/BluetoothAdapter.hpp"}, useQuotes = false)
@CxxClass("tinyb::BluetoothAdapter")
@CxxDefaultConstructorUnavailable
public interface BluetoothAdapter extends CxxObject {

    @CxxConstructor
    public static UniquePtr<BluetoothAdapter> create(BluetoothAdapter bluetoothAdapter) {
        throw new CxxExpectedGeneratedCodeException();
    }

    /* D-Bus method calls: */

    /**
     * Turns on device discovery if it is disabled.
     *
     * @return TRUE if discovery was successfully enabled
     */
    @CxxMethod
    public boolean start_discovery(
    );

    /**
     * Turns off device discovery if it is enabled.
     *
     * @return TRUE if discovery was successfully disabled
     */
    @CxxMethod
    public boolean stop_discovery(
    );


    /**
     * Returns a list of BluetoothDevices visible from this adapter.
     *
     * @return A list of BluetoothDevices visible on this adapter,
     * NULL if an error occurred
     */
    @CxxMethod
    @CxxByValue
    public UniquePtr_Vector<UniquePtr<BluetoothDevice>> get_devices(
    );

    /* D-Bus property accessors: */

    /**
     * Returns the hardware address of this adapter.
     *
     * @return The hardware address of this adapter.
     */
    @CxxMethod
    @CxxByValue
    public StdString get_address();

    /**
     * Returns the system name of this adapter.
     *
     * @return The system name of this adapter.
     */
    @CxxMethod
    @CxxByValue
    public StdString get_name();

    /**
     * Returns the friendly name of this adapter.
     *
     * @return The friendly name of this adapter, or NULL if not set.
     */
    @CxxMethod
    @CxxByValue
    public StdString get_alias();

    /**
     * Sets the friendly name of this adapter.
     */
    @CxxMethod
    public void set_alias(@CxxConst @CxxByReference StdString value);

    /**
     * Returns the Bluetooth class of the adapter.
     *
     * @return The Bluetooth class of the adapter.
     */
    @CxxMethod
    public int get_class();

    /**
     * Returns the power state the adapter.
     *
     * @return The power state of the adapter.
     */
    @CxxMethod
    public boolean get_powered();

    /**
     * Sets the power state the adapter.
     */
    @CxxMethod
    public void set_powered(boolean value);

    /**
     * Returns the discoverable state the adapter.
     *
     * @return The discoverable state of the adapter.
     */
    @CxxMethod
    public boolean get_discoverable();

    /**
     * Sets the discoverable state the adapter.
     */
    @CxxMethod
    public void set_discoverable(boolean value);

    /**
     * Returns the discoverable timeout the adapter.
     *
     * @return The discoverable timeout of the adapter.
     */
    @CxxMethod
    public int get_discoverable_timeout();

    /**
     * Sets the discoverable timeout the adapter. A value of 0 disables
     * the timeout.
     */
    @CxxMethod
    public void set_discoverable_timeout(int value);

    /**
     * Returns the pairable state the adapter.
     *
     * @return The pairable state of the adapter.
     */
    @CxxMethod
    public boolean get_pairable();

    /**
     * Sets the discoverable state the adapter.
     */
    @CxxMethod
    public void set_pairable(boolean value);

    /**
     * Returns the timeout in seconds after which pairable state turns off
     * automatically, 0 means never.
     *
     * @return The pairable timeout of the adapter.
     */
    @CxxMethod
    public int get_pairable_timeout();

    /**
     * Sets the timeout after which pairable state turns off automatically, 0 means never.
     */
    @CxxMethod
    public void set_pairable_timeout(int value);

    /**
     * Returns the discovering state the adapter. It can be modified through
     * start_discovery/stop_discovery functions.
     *
     * @return The discovering state of the adapter.
     */
    @CxxMethod
    public boolean get_discovering();

    /**
     * Returns the UUIDs of the adapter.
     *
     * @return Array containing the UUIDs of the adapter, ends with NULL.
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
}
