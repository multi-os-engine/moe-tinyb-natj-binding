package tinyb;

import org.moe.natj.cxx.ann.*;
import std.*;

@CxxHeader(value = {"tinyb/BluetoothManager.hpp"}, useQuotes = false)
@CxxClass("tinyb::BluetoothManager")
@CxxDefaultConstructorUnavailable
@CxxCopyConstructorUnavailable
public interface BluetoothManager extends BluetoothObject {

    @CxxMethod
    @CxxByValue
    public UniquePtr_Vector<UniquePtr<BluetoothObject>> get_objects(@CxxEnum("tinyb::BluetoothType") int type, StdString name, StdString identifier, BluetoothObject parent);

    /**
     * Returns a list of BluetoothAdapters available in the system
     *
     * @return A list of BluetoothAdapters available in the system
     */
    @CxxMethod
    @CxxByValue
    public UniquePtr_Vector<UniquePtr<BluetoothAdapter>> get_adapters(
    );

    /**
     * Returns a list of discovered BluetoothDevices
     *
     * @return A list of discovered BluetoothDevices
     */
    @CxxMethod
    @CxxByValue
    public UniquePtr_Vector<UniquePtr<BluetoothDevice>> get_devices(
    );

    /**
     * Returns a list of available BluetoothGattServices
     *
     * @return A list of available BluetoothGattServices
     */
    @CxxMethod
    @CxxByValue
    public UniquePtr_Vector<UniquePtr<BluetoothGattService>> get_services(
    );

    /**
     * Sets a default adapter to use for discovery.
     *
     * @return TRUE if the device was set
     */
    @CxxMethod
    public boolean set_default_adapter(BluetoothAdapter adapter);

    /**
     * Turns on device discovery on the default adapter if it is disabled.
     *
     * @return TRUE if discovery was successfully enabled
     */
    @CxxMethod
    public boolean start_discovery();

    /**
     * Turns off device discovery on the default adapter if it is enabled.
     *
     * @return TRUE if discovery was successfully disabled
     */
    @CxxMethod
    public boolean stop_discovery();
}
