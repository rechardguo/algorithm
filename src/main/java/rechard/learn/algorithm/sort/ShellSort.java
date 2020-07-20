package rechard.learn.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

public class ShellSort {
	@Test
	public  void check(){
		for(int i=0;i<100;i++) {
			int[] arr = SortUtil.generateArr(i);
			int[] arr2 = SortUtil.clone(arr);
			sort(arr);
			BubboSort.sort(arr2);
			Assert.assertArrayEquals(arr, arr2);
		}
	}
	public static  void sort(int[] arr){
		for(int gap = arr.length/2;gap>0;gap/=2){
			for(int i=gap;i<arr.length;i++){
				int j=i;
				while(j>=gap){
					if(arr[j]<arr[j-gap])
						SortUtil.swap(arr,j,j-gap);
					j-=gap;
				}
			}
		}
	}
}
