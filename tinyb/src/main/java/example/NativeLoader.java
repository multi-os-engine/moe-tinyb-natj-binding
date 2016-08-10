package example;

public class NativeLoader {

    public static void load() {
        try {
            System.loadLibrary("natj");
            System.loadLibrary("tinyb");
            System.loadLibrary("tinyb-java");
            System.out.println("Static library loaded");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
