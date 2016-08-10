package std;


import org.moe.natj.cxx.CxxObject;
import org.moe.natj.cxx.ann.CxxCopyConstructorUnavailable;
import org.moe.natj.cxx.ann.CxxDestructorUnavailable;
import org.moe.natj.cxx.ann.CxxMethod;
import org.moe.natj.cxx.ann.CxxTemplate;

@CxxTemplate("std::unique_ptr<{{T}}>")
@CxxDestructorUnavailable
@CxxCopyConstructorUnavailable
public interface UniquePtr<T extends CxxObject> extends CxxObject {

    @CxxMethod(isConst = true)
    public T get();
}
