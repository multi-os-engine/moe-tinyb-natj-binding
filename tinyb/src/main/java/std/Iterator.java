package std;

import org.moe.natj.cxx.CxxObject;
import org.moe.natj.cxx.CxxOperatorKind;
import org.moe.natj.cxx.ann.*;

@CxxTemplate("std::vector<{{T}}>::iterator")
public interface Iterator<T extends CxxObject> extends CxxObject {

    @CxxOperator(CxxOperatorKind.INDIRECT)
    @CxxConst
    @CxxByReference
    T get();

    @CxxOperator(CxxOperatorKind.PRE_INCREMENT)
    @CxxByReference
    Iterator<T> succ();
}
