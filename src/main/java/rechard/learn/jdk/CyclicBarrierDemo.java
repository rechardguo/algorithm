package rechard.learn.jdk;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * new CyclicBarrier(n，action)  n 表示要几个同时完成，后面的action 才能进行下去。
 * 比如说有个文件分成10个进行统计，要所有的文件都统计完了才成进行下去。
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {

        fileSum();
        fileSum2();
    }

    //文件统计2
    //用上线程池，每满5个统计,统计完了就又继续下去
    //和CountDownLatch的区别就是CyclicBarrier能循环使用
    public static void fileSum2(){
        int [] fileNumbers=new int[]{1,2,3,4,5,6,7,8,9,10};
        AtomicInteger sum=new AtomicInteger();
        AtomicInteger count=new AtomicInteger();
        int taskNumber=5;
        CyclicBarrier barrier=new CyclicBarrier(taskNumber,()->{
            System.out.println("第"+count.addAndGet(1)+"次统计结束，统计的结果:"+sum.get());
        });

        ExecutorService service=Executors.newFixedThreadPool(taskNumber);

        for(int i=0;i<fileNumbers.length;i++){
            final int number=fileNumbers[i];
            service.submit(()->{
                try {
                    sum.addAndGet(number);
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        service.shutdown();
    }


    //文件统计
    public static void fileSum(){
        int [] fileNumbers=new int[]{1,2,3,4,5,6,7,8,9,10};
        AtomicInteger sum=new AtomicInteger();

        CyclicBarrier barrier=new CyclicBarrier(fileNumbers.length,()->{
            System.out.println("统计结束，统计的结果:"+sum.get());
        });
        for(int i=0;i<fileNumbers.length;i++){
            final int number=fileNumbers[i];
            new Thread(()->{
                try {
                    sum.addAndGet(number);
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    //简单的演示
    public static void simple(){
        CyclicBarrier c =new CyclicBarrier(2,()->{
            System.out.println("2个线程都完成了");

        });
        new Thread(()->{

            System.out.println(1);
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{

            System.out.println(2);
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
