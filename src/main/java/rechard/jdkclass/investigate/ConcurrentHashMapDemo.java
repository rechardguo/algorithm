package rechard.jdkclass.investigate;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

    static class MyObject{
        int val;

        public MyObject(final int val) {
            this.val = val;
        }

        @Override
        public int hashCode() {
            return 1;
        }
    }
    public static void main(String[] args) {
        ConcurrentHashMap m=new ConcurrentHashMap();
        for(int i=0;i<100;i++)
        m.put(new MyObject(i),new Object());


        System.out.println(m.size());
    }
}


