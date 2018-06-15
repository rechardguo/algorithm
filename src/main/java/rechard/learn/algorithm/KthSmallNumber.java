package rechard.learn.algorithm;

public class KthSmallNumber {


	public static int find(int[] arr,int x,int y,int k){
		int i=x,j=y;
		int flag=arr[0];
		boolean isLeftTurn=true;
		while(i<j){
			if(isLeftTurn){
				if(arr[j]<flag){
					arr[i]=arr[j];
					isLeftTurn=false;
				}else
					j--;
			}else{
				if(arr[i]>flag){
					arr[j]=arr[i];
					isLeftTurn=true;
				}else
					i++;
			}
		}
		if(i==k-1)
			return arr[i];
		else if(i<k-1)
			return find(arr,i+1,y,k-(i==0?1:i));
		else
			return find(arr,x,i-1,k-1);
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{3,4,5,6,7};
		System.out.println(find(arr,0,arr.length-1,3));
	}
}
