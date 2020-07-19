package rechard.learn.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * 对2个有序数组合并成为1个
 * @author Rechard
 *
 */
public class Mergesort2 {

	@Test
	public void check() {
		int[] arr1 = new int[]{5,6,7,7};
		int[] arr2 = new int[]{7,8,9};
		int[] arr=mergesort(arr1,arr2);
		Assert.assertArrayEquals(arr,new int[]{5,6,7,7,7,8,9});
	}

	private static int[] mergesort(int[] arr1,int[]arr2){
		if(arr1==null) return arr2;
		if(arr2==null) return arr1;
		int i=0,j=0,k=0;
		int[] tmpArr=new int[arr1.length+arr2.length];
		while(i<arr1.length && j<arr2.length){
			if(arr1[i]<=arr2[j]){
				tmpArr[k++]=arr1[i++];
			}else{
				tmpArr[k++]=arr2[j++];
			}
		}
		while(i<arr1.length){
			tmpArr[k++]=arr1[i++];
		}
		while(j<arr2.length){
			tmpArr[k++]=arr2[j++];
		}
		return tmpArr;
	}


}
