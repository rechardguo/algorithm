package rechard.learn.algorithm.search;

import org.junit.Test;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * 二分查找的算法
 * 基本模式
 * @author Rechard
 *
 */
public class BinarySearch {
	@Test
	public  void check() {
		int[] arr=new int[]{1,4,5,6,7,8};
		assertEquals(2, binarysearch(arr,5));
		assertEquals(0, binarysearch(arr,1));
		assertEquals(5, binarysearch(arr,8));
		assertEquals(-1, binarysearch(arr,9));
	}
	public static int binarysearch(int []arr ,int val){
		if(arr==null || arr.length==0)
			return -1;
		int begin=0;
		int end=arr.length-1;
		while(begin<=end){
			int mid = begin+(end-begin>>1);
			if(arr[mid]>val){
				end = mid-1;
			}else if(arr[mid]<val){
				begin = mid+1;
			}else{
				return mid;
			}
		}
		return -1;
	}

}
