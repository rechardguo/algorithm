package rechard.learn.algorithm.muliplethread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 总共有n个苹果
 * 猴子拿苹果，
 * 猴子1 每次拿2个，如果不足则停止拿苹果
 * 猴子2 每次拿3个，如果不足则停止拿苹果
 *
 * 程序模拟该过程，主要是多线程的同步
 *
 * 该例子使用ReentrantLock
 */
public class MonkeyEatApple2 {

    public static  class ApplePool{
        private int number=0;
        private Lock lock=new ReentrantLock();
        public ApplePool(int number) {
            this.number=number;

        }

        public int take(int takeNum){
            int res=-1;
            lock.lock();
            if(number>=takeNum) {
                number -= takeNum;
                res=takeNum;
            }
            lock.unlock();
            return res;

        }
    }

    public static class Monkey extends Thread{
        private String name;
        private ApplePool applePool;
        private int takeAppleNumberPerTime;

        public Monkey(ApplePool applePool, int takeAppleNumberPerTime,String name) {
            this.applePool = applePool;
            this.takeAppleNumberPerTime = takeAppleNumberPerTime;
            this.name=name;
        }

        public void run() {

            while(applePool.take(takeAppleNumberPerTime)!=-1){
                System.out.println(name +" take "+takeAppleNumberPerTime+" apples");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(name +" stop take apple");
        }
    }

    public static void main(String[] args) {
        ApplePool applePool=new ApplePool(9);
        new Monkey(applePool,2,"monkey1").start();
        new Monkey(applePool,3,"monkey2").start();
    }
}
