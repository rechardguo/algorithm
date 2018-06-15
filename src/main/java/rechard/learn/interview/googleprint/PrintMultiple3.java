package rechard.learn.interview.googleprint;

//不受线程的start顺序控制
public class PrintMultiple3 {
	private volatile int i = 0;
	private Object lock = new Object();
	private int max =0 ;
	public PrintMultiple3(int max){
		this.max= max;
	}
	
	public  void incrAndPrint(boolean odd){
		while(i<max){
			synchronized(lock){
				if(isMyTurn(odd)){
					System.out.println(Thread.currentThread().getName()+" is : " + (++i));
					try {
						lock.notify();
						if(i<max)
							lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	private boolean isMyTurn(boolean odd){
		return odd?i%2==0:i%2!=0;
	}
	public static void main(String[] args) {
		PrintMultiple3 pm = new PrintMultiple3(100);
		new Thread(new Runnable(){
			public void run(){
				pm.incrAndPrint(false);
			}
		},"t2").start();
		new Thread(new Runnable(){
			public void run(){
				pm.incrAndPrint(true);
			}
		},"t1").start();		
	}

}
