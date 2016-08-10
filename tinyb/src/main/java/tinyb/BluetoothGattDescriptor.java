package tinyb;

import org.moe.natj.cxx.CxxExpectedGeneratedCodeException;
import org.moe.natj.cxx.ann.*;
import std.StdString;
import std.UniquePtr;
import std.UChar_Vector;

@CxxHeader(value = {"tinyb/BluetoothGattDescriptor.hpp"}, useQuotes = false)
@CxxClass("tinyb::BluetoothGattDescriptor")
@CxxDefaultConstructorUnavailable
public interface BluetoothGattDescriptor extends BluetoothObject {

    @CxxConstructor
    public static UniquePtr<BluetoothGattDescriptor> create(BluetoothGattDescriptor bluetoothGattDescriptor) {
        throw new CxxExpectedGeneratedCodeException();
    }

    /* D-Bus method calls: */

    /**
     * Reads the value of this descriptor
     *
     * @return A vector<uchar> containing data from this descriptor
     */
    @CxxMethod
    @CxxByValue
    public UChar_Vector read_value(
    );

    /**
     * Writes the value of this descriptor.
     *
     * @return TRUE if value was written succesfully
     * @param[in] arg_value The data as vector<uchar>
     * to be written packed in a GBytes struct
     */
    @CxxMethod
    public boolean write_value(
            @CxxConst @CxxByReference UChar_Vector arg_value
    );

    /* D-Bus property accessors: */

    /**
     * Get the UUID of this descriptor.
     *
     * @return The 128 byte UUID of this descriptor, NULL if an error occurred
     */
    @CxxMethod
    @CxxByValue
    public StdString get_uuid();

    /**
     * Returns the characteristic to which this descriptor belongs to.
     *
     * @return The characteristic.
     */
    @CxxMethod
    @CxxByValue
    public BluetoothGattCharacteristic get_characteristic();

    /**
     * Returns the cached value of this descriptor, if any.
     *
     * @return The cached value of this descriptor.
     */
    @CxxMethod
    @CxxByValue
    public UChar_Vector get_value();
}
