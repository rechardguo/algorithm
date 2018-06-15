package rechard.learn.interview.googleprint;

public class PrintMultiple2 {
	private volatile int i = 0;
	private int max =0 ;
	public PrintMultiple2(int max){
		this.max= max;
	}
	public Object lock = new Object();
	public  void incrAndPrint(){
		synchronized(lock){
			while(i<max){
					System.out.println(Thread.currentThread().getName()+" is : " + (++i));
					try {
						lock.notify();
						if(i<max)
							lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}}
	}

	public static void main(String[] args) {
		PrintMultiple2 pm = new PrintMultiple2(100);
		new Thread(new Runnable(){
			public void run(){
				pm.incrAndPrint();
			}
		},"t1").start();		
		new Thread(new Runnable(){
			public void run(){
				pm.incrAndPrint();
			}
		},"t2").start();

	}

}
