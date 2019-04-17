package rechard.learn.jzoffer;

public class nplug {
	public static void main(String[] args) {
		System.out.println(Sum_Solution(100));
	}
	//利用了短路
	public static int Sum_Solution(int n) {
		int ans=n;
		boolean b = (ans>0) && ((ans+=Sum_Solution(--n))>0);
		return ans;
	}
}
