package tinyb;

import org.moe.natj.cxx.CxxExpectedGeneratedCodeException;
import org.moe.natj.cxx.CxxMethodVirtuality;
import org.moe.natj.cxx.CxxObject;
import org.moe.natj.cxx.CxxOperatorKind;
import org.moe.natj.cxx.ann.*;
import std.StdString;
import std.UniquePtr;

@CxxHeader(value = {"tinyb/BluetoothObject.hpp"}, useQuotes = false)
@CxxClass("tinyb::BluetoothObject")
@CxxDefaultConstructorUnavailable
public interface BluetoothObject extends CxxObject {

    @CxxConstructor
    public static UniquePtr<BluetoothObject> create(BluetoothObject bluetoothObject) {
        throw new CxxExpectedGeneratedCodeException();
    }

    @CxxMethod(virtuality = CxxMethodVirtuality.VIRTUAL)
    @CxxByValue
    public StdString get_object_path();

    /**
     * Returns the BluetoothType of this object
     *
     * @return The BluetoothType of this object
     */
    @CxxMethod(virtuality = CxxMethodVirtuality.VIRTUAL)
    @CxxEnum("tinyb::BluetoothType")
    public int get_bluetooth_type();

    /**
     * Returns a raw pointer to a clone of the object
     *
     * @return A raw pointer to a clone of the object
     */
    @CxxMethod(virtuality = CxxMethodVirtuality.VIRTUAL)
    public BluetoothObject clone();

    /**
     * Returns true if this object and the other point to the same DBus Object
     *
     * @return True if this object and the other point to the same DBus Object
     */
    @CxxOperator(CxxOperatorKind.EQUAL)
    public boolean equals(@CxxByReference BluetoothObject other);
}
