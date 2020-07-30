package rechard.jdkclass.investigate.pool;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

public class Test {
    @org.junit.Test
    public void forLoop(){
        long[] numbers = LongStream.rangeClosed(1, 10000000).toArray();

        Instant start = Instant.now();
        Calculator calculator = new ForLoopCalculator();
        long result = calculator.sumUp(numbers);
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis() + "ms"); //10ms

        System.out.println("结果为：" + result);
    }

    @org.junit.Test
    public void executor(){
        long[] numbers = LongStream.rangeClosed(1, 10000000).toArray();

        Instant start = Instant.now();
        Calculator calculator = new ExecutorServiceCalculator();
        long result = calculator.sumUp(numbers);
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis() + "ms");//30ms

        System.out.println("结果为：" + result); // 打印结果500500
    }
}
