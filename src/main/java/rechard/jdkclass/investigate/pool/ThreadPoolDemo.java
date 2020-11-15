package rechard.jdkclass.investigate.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService service=Executors.newFixedThreadPool(2);
        for (int i = 0; i < 4; i++) {
            final int index=i;
            service.submit(() -> {
                for (; ; ) {
                    System.out.println(index);
                    TimeUnit.SECONDS.sleep(1);
                }
            });

        };
        service.shutdown();

    }
}
