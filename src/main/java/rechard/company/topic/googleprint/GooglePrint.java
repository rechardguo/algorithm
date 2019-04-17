package rechard.company.topic.googleprint;

public class GooglePrint {
	static volatile int i=1;
	private static Object lock = new Object();
	static class Thr extends Thread{
		private int intrestNumber = 1;
		public Thr(int intrestNumber){
			this.intrestNumber = intrestNumber;
		}
		public void run(){
			while(true){
				synchronized(lock){
					if(i==intrestNumber){
						System.out.print(intrestNumber);
						i++;
						lock.notifyAll();
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	public  static void run(int start){
		i=start;
		for(;;){
			new Thr(1).start();
			new Thr(2).start();
			new Thr(3).start();
			new Thr(4).start();
			if(i==5)
				i=1;
		}
	}

	public static void main(String[] args) {
		run(4);
	}
}
