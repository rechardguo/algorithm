package rechard.learn.algorithm;

public class nplug {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//利用了短路
	 public int Sum_Solution(int n) {
	        int ans=n;
	        boolean b = (ans>0) && ((ans+=Sum_Solution(--n))>0);
	        return ans;
	    }

}
