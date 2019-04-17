package rechard.company.topic.googleprint;

public class PrintMultiple {

	public int i = 0;
	public Object lock = new Object();
	public void incr(){
		synchronized(lock){
			System.out.println(Thread.currentThread().getName()+" : " + (++i));
			try {
				lock.notify();
				if(i<100)
					lock.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		final PrintMultiple pm = new PrintMultiple();
		new Thread(new Runnable(){
			public void run(){
				for(int i=0;i<50;i++){
					pm.incr();
				}
			}
		},"t1").start();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(new Runnable(){
			public void run(){
				for(int i=0;i<50;i++){
					pm.incr();
				}
			}
		},"t2").start();

	}

}
