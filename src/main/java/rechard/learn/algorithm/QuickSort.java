package rechard.learn.algorithm;

/**
 * 快排
 * @author Rechard
 *
 */
public class QuickSort {

	public static void main(String[]args){
		
		int[] arr = new int[]{20,15,32,66,33,-1,10,4,5,8,4,4};
		quickSort(arr,0,arr.length-1);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void quickSort(int arr[],int low,int hight){
		if(arr==null || arr.length<=1)
			return;
		if(low>=hight)
			return;
		int mark=arr[low];
		int i=low;
		int j=hight;
		boolean rightScan = true;
		while(i<j){
			if(rightScan){
				for(;j>i;j--){
					if(arr[j]<mark){
						int tmp = arr[i];
						arr[i] = arr[j];
						arr[j] =tmp; 
						rightScan=false;
						break;
					}
				}
			}else{
				for(;i<j;i++){
					if(arr[i]>mark){
						int tmp = arr[i];
						arr[i] = arr[j];
						arr[j] = tmp; 
						rightScan=true;
						break;
					}
				}
			}
		}
		quickSort(arr,low,i-1);
		quickSort(arr,j+1,hight);
	}

}
