package rechard.learn.algorithm.sort;
/**
 * 对2个有序数组合并成为1个
 * @author Rechard
 *
 */
public class Mergesort2 {

	public static void main(String[] args) {
		int[] arr1 = new int[]{5,6,7,7};
		int[] arr2 = new int[]{7,8,9};
		int[] arr=mergesort(arr1,arr2);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	private static int[] mergesort(int[] arr1,int[]arr2){
		int i=0;
		int j=0;
		int k=0;
		int[] a1= new int[arr1.length+1];
		int[] a2= new int[arr2.length+1];
		int[] tmpArr=new int[arr1.length-arr2.length];
		while(i<a1.length){
			if(a1[i]<=a2[j]){
				tmpArr[k++]=a1[i++];
			}else{
				tmpArr[k++]=a2[j++];
			}
		}
		return tmpArr;
	}


}
