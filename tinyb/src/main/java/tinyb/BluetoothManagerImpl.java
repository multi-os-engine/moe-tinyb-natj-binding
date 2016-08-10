package tinyb;

import org.moe.natj.cxx.ann.CxxFunction;
import org.moe.natj.cxx.ann.CxxHeader;

@CxxHeader(value = {"tinyb/BluetoothManager.hpp"}, useQuotes = false)
public class BluetoothManagerImpl {

    @CxxFunction("tinyb::BluetoothManager::get_bluetooth_manager")
    public static native BluetoothManager get_bluetooth_manager();
}
