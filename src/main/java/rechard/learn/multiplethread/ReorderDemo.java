package rechard.learn.multiplethread;

public class ReorderDemo {

    static class Container{
        private int val=0;
        private boolean flag;
        //这里的2句有可能乱序
        private void modify() throws InterruptedException {
            Thread.sleep(1);
            val=1;
            flag=true;
        }
        //一旦modify里的乱序后，flag=true先执行，val还是0
        //打印出的是0

        //如果没有乱序，打印出的是1
        private void read(){
            if(flag){
                if(val==0)
                System.out.println(this.val);
            }
        }

    }

    public static void main(String[] args) {
        for(int i=0;i<10000;i++){
            demo();
        }
    }


    public static void demo(){
        final Container c=new Container();
        new Thread(()->{
            try {
                c.modify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            c.read();
        }).start();
    }

}
