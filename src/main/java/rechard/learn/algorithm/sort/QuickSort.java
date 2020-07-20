package rechard.learn.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * 快排
 *
 * @author Rechard
 * quickSort 之前写的
 * quickSort2 后面听课程写的
 *
 *  快排看https://blog.csdn.net/holmofy/article/details/71168530#t7
 *
 */
public class QuickSort {

	@Test
	public  void check(){
		for(int i=0;i<100;i++) {
			//	int[] arr = new int[]{20,15,32,66,33,-4,-9,-100,100,-1,10,4,5,8,4,4};
			// int[] arr2 = new int[]{20,15,32,66,33,-4,-9,-100,100,-1,10,4,5,8,4,4};
			int[] arr = SortUtil.generateArr(i);
			int[] arr2 = SortUtil.clone(arr);
			quickSort(arr, 0, arr.length - 1);
			quickSort2(arr2, 0, arr2.length - 1);
			Assert.assertArrayEquals(arr, arr2);
		}
	}

	 public static void quickSort2(int arr[],int low,int high){
		if(low<high) {
            int[] p = partition(arr, low, high);
            quickSort2(arr, low, p[0] - 1<0?0:p[0]-1);
            quickSort2(arr, p[1] + 1, high>arr.length?arr.length:high);
        }
	 }

	private static int[] partition(int[] arr, int low, int high) {
	 	int less=low-1;
	 	int more= high;
	 	while(low<more){
            if(arr[low]>arr[high]){
                swap(arr,low,--more);
            }else if(arr[low]<arr[high]){
                swap(arr,++less,low++);
            }else{
                low++;
            }
		}
		swap(arr,more,high);
	 	less = less<0 || arr[less]<arr[more]?more:less;
		return new int[]{less,more};
	}

	private static void swap(int[] arr, int i, int j) {
	 	int tmp=arr[i];
	 	arr[i]=arr[j];
	 	arr[j]=tmp;
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
