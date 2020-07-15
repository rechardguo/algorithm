package rechard.jdkclass.investigate;

import java.beans.Beans;
import java.io.IOException;

public class BeansInvestigate {

    public static void main(String[] args) {
        try {
            MockService ms=(MockService)Beans.instantiate(ClassLoader.getSystemClassLoader(),"rechard.jdkclass.investigate.MockService");
            System.out.println(ms);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
