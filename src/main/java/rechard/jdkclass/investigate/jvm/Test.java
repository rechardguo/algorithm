package rechard.jdkclass.investigate.jvm;

import java.lang.reflect.Constructor;

public class Test {
    public static void main(String[] args) {
            Class paramTypes[] = {
                    String.class, Integer.TYPE
            };
            try {
                Constructor constructor = Person.class.getConstructor(paramTypes);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
    }
}
