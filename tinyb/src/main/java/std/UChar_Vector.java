package std;

import org.moe.natj.cxx.CxxExpectedGeneratedCodeException;
import org.moe.natj.cxx.CxxObject;
import org.moe.natj.cxx.CxxOperatorKind;
import org.moe.natj.cxx.ann.*;
import org.moe.natj.general.ann.NULong;

@CxxHeader(value = "vector", useQuotes = false)
@CxxClass("std::vector<unsigned char>")
public interface UChar_Vector extends CxxObject {

    @CxxMethod(isConst = true)
    @NULong
    long size();

    @CxxOperator(value = CxxOperatorKind.SUBSCRIPT, isConst = true)
    @CxxUnsigned
    byte get(@NULong long index);

    @CxxMethod
    void push_back(@CxxUnsigned byte value);

    @CxxConstructor
    static UChar_Vector create() {
        throw new CxxExpectedGeneratedCodeException();
    }
}
