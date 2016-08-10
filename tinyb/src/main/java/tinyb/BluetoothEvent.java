package tinyb;

import org.moe.natj.cxx.CxxObject;
import org.moe.natj.cxx.CxxOperatorKind;
import org.moe.natj.cxx.ann.*;
import std.StdString;

@CxxHeader(value = {"tinyb/BluetoothEvent.hpp"}, useQuotes = false)
@CxxClass("tinyb::BluetoothEvent")
@CxxDefaultConstructorUnavailable
public interface BluetoothEvent extends CxxObject {

    @CxxMethod
    @CxxEnum("tinyb::BluetoothType")
    int get_type();

    @CxxMethod
    @CxxByValue
    public StdString get_name();

    @CxxMethod
    @CxxByValue
    public StdString get_identifier();

    @CxxMethod
    public boolean execute_callback();

    @CxxMethod
    public boolean has_callback();

    @CxxOperator(CxxOperatorKind.EQUAL)
    public boolean equals(@CxxConst @CxxByReference BluetoothEvent other);
}
