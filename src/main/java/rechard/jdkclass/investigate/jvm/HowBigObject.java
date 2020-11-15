package rechard.jdkclass.investigate.jvm;

import java.io.ObjectStreamClass;

public class HowBigObject {

    public static void main(String[] args) {
        ObjectStreamClass osc=ObjectStreamClass.lookup(Object.class);
    }
}
