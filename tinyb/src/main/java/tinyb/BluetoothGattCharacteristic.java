package tinyb;

import org.moe.natj.cxx.CxxExpectedGeneratedCodeException;
import org.moe.natj.cxx.ann.*;
import std.*;

@CxxHeader(value = {"tinyb/BluetoothGattCharacteristic.hpp"}, useQuotes = false)
@CxxClass("tinyb::BluetoothGattCharacteristic")
@CxxDefaultConstructorUnavailable
public interface BluetoothGattCharacteristic extends BluetoothObject {

    @CxxConstructor
    public static UniquePtr<BluetoothGattCharacteristic> create(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        throw new CxxExpectedGeneratedCodeException();
    }

    /* D-Bus method calls: */

    /**
     * Reads the value of this characteristic.
     *
     * @return A std::vector<unsgined char> containing the value of this characteristic.
     */
    @CxxMethod
    @CxxByValue
    public UChar_Vector read_value(
    );

    /**
     * Writes the value of this characteristic.
     *
     * @return TRUE if value was written succesfully
     * @param[in] arg_value The data as vector<uchar>
     * to be written packed in a GBytes struct
     */
    @CxxMethod
    public boolean write_value(@CxxConst @CxxByReference UChar_Vector arg_value);

    @CxxMethod
    public boolean start_notify(
    );

    @CxxMethod
    public boolean stop_notify(
    );

    /* D-Bus property accessors: */

    /**
     * Get the UUID of this characteristic.
     *
     * @return The 128 byte UUID of this characteristic, NULL if an error occurred
     */
    @CxxMethod
    @CxxByValue
    public StdString get_uuid();

    /**
     * Returns the service to which this characteristic belongs to.
     *
     * @return The service.
     */
    @CxxMethod
    @CxxByValue
    public BluetoothGattService get_service();

    /**
     * Returns the cached value of this characteristic, if any.
     *
     * @return The cached value of this characteristic.
     */
    @CxxMethod
    @CxxByValue
    public UChar_Vector get_value();

    /**
     * Returns true if notification for changes of this characteristic are
     * activated.
     *
     * @return True if notificatios are activated.
     */
    @CxxMethod
    public boolean get_notifying();

    /**
     * Returns the flags this characterstic has.
     *
     * @return A list of flags for this characteristic.
     */
    @CxxMethod
    @CxxByValue
    public Vector<StdString> get_flags();

    /**
     * Returns a list of BluetoothGattDescriptors this characteristic exposes.
     *
     * @return A list of BluetoothGattDescriptors exposed by this characteristic
     * NULL if an error occurred
     */
    @CxxMethod
    @CxxByValue
    public UniquePtr_Vector<UniquePtr<BluetoothGattDescriptor>> get_descriptors();
}
