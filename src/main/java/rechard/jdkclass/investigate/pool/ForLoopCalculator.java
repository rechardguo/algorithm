package rechard.jdkclass.investigate.pool;

public class ForLoopCalculator implements Calculator {
    public long sumUp(long[] numbers) {
        long total = 0;
        for (long i : numbers) {
            total += i;
        }
        return total;
    }
}
