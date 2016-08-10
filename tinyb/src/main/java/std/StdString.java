package std;

import org.moe.natj.cxx.CxxExpectedGeneratedCodeException;
import org.moe.natj.cxx.CxxObject;
import org.moe.natj.cxx.ann.*;
import org.moe.natj.general.ann.NULong;
import org.moe.natj.general.ptr.BytePtr;
import org.moe.natj.general.ptr.ConstBytePtr;
import org.moe.natj.general.ptr.impl.PtrFactory;

import java.io.UnsupportedEncodingException;

@CxxHeader(value = "string", useQuotes = false)
@CxxClass("std::string")
public interface StdString extends CxxObject {

    @CxxMethod(isConst = true)
    @NULong
    long length();

    @CxxMethod(isConst = true)
    ConstBytePtr c_str();

    @CxxConstructor
    static StdString create(BytePtr ptr, @NULong long len) {
        throw new CxxExpectedGeneratedCodeException();
    }

    default String getString() {
        return c_str().toUTF8String();
    }

    static StdString getStdString(String s) {
        try {
            final byte[] bytes = s.getBytes("UTF-8");
            final BytePtr bytePtr = PtrFactory.newByteArray(bytes);
            return create(bytePtr, bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UnsupportedEncodingException occurred", e);
        }
    }

    static BytePtr getBytePtr(String s) {
        try {
            final byte[] bytes = s.getBytes("UTF-8");
            return PtrFactory.newByteArray(bytes);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UnsupportedEncodingException occurred", e);
        }
    }
}
