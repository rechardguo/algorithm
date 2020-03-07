package rechard.learn.algorithm.muliplethread;

public class MonkeyEatApple {

    public static  class ApplePool{
        private int number=0;
        public ApplePool(int number) {
            this.number=number;
        }
        public int take(int takeNum){
            synchronized (ApplePool.class){
                if(number>=takeNum) {
                    number -= takeNum;
                    return takeNum;
                }else{
                    return -1;
                }
            }
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
