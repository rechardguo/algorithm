package rechard.learn.algorithm.sort;
/**
 * 归并排序算法
 * @author Rechard
 *
 */
public class Mergesort {

	public static void main(String[] args) {
		int[] arr = new int[]{9,3,7,2,8,5,1,6};
		sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void sort(int[] arr){
		if(arr==null)
			return;
		sort(arr,0,arr.length-1,new int[arr.length]);
	}
	
	private static  void sort(int[] arr,int first,int last,int[] newarr){
		if(first<last){
			sort(arr,first,(first+last)/2,newarr);
			sort(arr,(first+last)/2+1,last,newarr);
			megerArray(arr,first,last,newarr);
		}
	}
	/**1.合并
		 arr 的 first---(first+last)/2   
		 arr 的 (first+last)/2+1---last 
		  到newarr
	   2.将newarr里的有序数组换回到arr里	  
	**/
	private static void megerArray(int[]arr,int first,int last,int[]newarr){		
		int i=first;
		int mid=(first+last)/2;
		int n=mid+1;
		int k=0;
		while(i<=mid && n<=last){
			if(arr[i]<arr[n]){
				newarr[k++]=arr[i++];
			}else{
				newarr[k++]=arr[n++];
			}
		}
		while(i<=mid)
			newarr[k++]=arr[i++];
		
		while(n<=last)
			newarr[k++]=arr[n++];
		
		//arr排序
		for(int y=0;y<k;y++){
			arr[first+y]=newarr[y];
		}
		
	}
	

}
