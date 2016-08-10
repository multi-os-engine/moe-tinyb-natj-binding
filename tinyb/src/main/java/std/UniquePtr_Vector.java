package std;

import org.moe.natj.cxx.CxxObject;
import org.moe.natj.cxx.CxxOperatorKind;
import org.moe.natj.cxx.ann.*;
import org.moe.natj.general.ann.NULong;
import tinyb.BluetoothAdapter;

@CxxHeader(value = "vector", useQuotes = false)
@CxxTemplate("std::vector<{{T}}>")
@CxxCopyConstructorUnavailable
public interface UniquePtr_Vector<T extends CxxObject> extends CxxObject {

    @CxxMethod(isConst = true)
    @NULong
    long size();

    @CxxOperator(value = CxxOperatorKind.SUBSCRIPT, isConst = true)
    @CxxConst
    @CxxByReference
    T get(@NULong long index);

}
