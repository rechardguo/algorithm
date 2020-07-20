package rechard.learn.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * 快排
 *
 * 比较好写的一个版本，记这个就可以了
 *
 * 图可以看
 * 快排看https://blog.csdn.net/holmofy/article/details/71168530#t7
 * @author Rechard
 *
 *
 *
 */
public class QuickSort3 {

	@Test
	public  void check(){
		for(int i=0;i<100;i++) {
			int[] arr = SortUtil.generateArr(i);
			int[] arr2 = SortUtil.clone(arr);
			sort(arr,0,arr.length-1);
			BubboSort.sort(arr2);
			Assert.assertArrayEquals(arr, arr2);
		}
	}

	 public static void sort(int arr[],int low,int high){
		  if(arr==null || arr.length==0)return;
          if(low<high) {
			  int pivot = arr[low];
			  int i = low + 1;
			  int j = high;
			  while (i <= j) {
				  while (i <= j && arr[i] < pivot) i++;
				  while (i <= j && arr[j] >= pivot) j--;
				  if(i<j)
				    SortUtil.swap(arr, i, j);
			  }
			  SortUtil.swap(arr, low, j);
			  sort(arr, low, j-1);
			  sort(arr, j+1, high);
		  }
	 }



}
