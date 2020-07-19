package rechard.learn.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * 归并排序算法
 * @author Rechard
 *
 */
public class Mergesort {

	@Test
	public  void check() {
		for (int i=0;i<100;i++){
			int [] arr =SortUtil.generateArr(i);
			int [] arrCopy=SortUtil.clone(arr);
			sort(arr);
			BubboSort.sort(arrCopy);
			Assert.assertArrayEquals(arr,arrCopy);
		}
	}
	
	public static void sort(int[] arr){
		if(arr==null)
			return;
		sort(arr,0,arr.length-1);
	}
	
	private static  void sort(int[] arr,int first,int last){
		if(first<last){
			//first+last>>2 容易发生溢出
			int mid=first+((last-first)>>>1);
			//sort左边
			sort(arr,first,mid);
			//sort右边
			sort(arr,mid+1,last);
			megerArray(arr,first,mid,last);
		}
	}
	/**1.合并
		 arr 的 first---(first+last)/2   
		 arr 的 (first+last)/2+1---last 
		  到newarr
	   2.将newarr里的有序数组换回到arr里	  
	**/
	private static void megerArray(int[]arr,int first,int mid,int last){
		int i=first;
		int j=mid+1;
		int k=0;
		int[] tmpArr=new int[last-first+1]; //  new 出1个临时数组，长度是last-first+1
		while(i<=mid && j<=last){
			if(arr[i]<arr[j]){
				tmpArr[k++]=arr[i++];
			}else{
				tmpArr[k++]=arr[j++];
			}
		}
		while(i<=mid)
			tmpArr[k++]=arr[i++];

		while(j<=last)
			tmpArr[k++]=arr[j++];

		//将排序号的临时数组拷贝回去
		for(int y=0;y<k;y++){
			arr[first+y]=tmpArr[y];
		}

	}


}
