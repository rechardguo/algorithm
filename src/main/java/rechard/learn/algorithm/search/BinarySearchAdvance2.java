package rechard.learn.algorithm.search;

import org.junit.Assert;
import org.junit.Test;

/**
 * 二分查找的高级算法
 * 在基本模式的基础上
 *
 * 给定一个排序的数组，目标值可能有多个，找出边界
 *
 * 例如给定 1，2，2，2，3
 * 目标值为2,返回[1,3]
 * 目标值为1,返回[0,0]
 * 目标值为3,返回[4,4]
 * 找不到返回,返回[-1,-1]
 *
 * 要求O(log2n）
 *
 *
 * 在BinarySearchAdvance 基础上改进，
 * 先用二分查找到是否有存在目标值，如果不存在直接返回-1,-1
 * 如果存在再用left和right的二分查找找到边界值
 * @author Rechard
 *
 */
public class BinarySearchAdvance2 {
	@Test
	public  void check() {
		int[] arr=new int[]{1,2,2,2,3};
		Assert.assertArrayEquals(new int[]{0,0},binarysearchadv(arr,1));
		Assert.assertArrayEquals(new int[]{1,3},binarysearchadv(arr,2));
		Assert.assertArrayEquals(new int[]{4,4},binarysearchadv(arr,3));
		Assert.assertArrayEquals(new int[]{-1,-1},binarysearchadv(arr,4));
	}



	public int[] binarysearchadv(int []arr ,int val){
		if(arr==null) return null;
		int mid=binarysearch(arr,val);
		if(mid==-1)return new int[]{-1,-1};

		int left =left(arr,val,0,mid);
		int right=right(arr,val,mid,arr.length-1);
		if(left==right)
		  return new int[]{left,right};
		else
			return left==-1? new int[]{right,right}:right==-1?new int[]{left,left}:new int[]{left,right};
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


	public int left(int[]arr ,int val,int begin,int end){
		while(begin<end){
			int mid= begin+(end-begin>>1);

			if(arr[mid]<val){
				begin=mid+1;
			}else if(arr[mid]>val){
				end=mid-1;
			}else{
				// 1,2,2,2,1
				// i   j
				if(end==mid)break;
				end=mid;
			}
		}
		if(arr[begin]==val)return begin;
		if(arr[end]==val)return end;
		return -1;
	}
	public int right(int[]arr ,int val,int begin,int end){
		while(begin<end){
			int mid= begin+(end-begin>>1);

			if(arr[mid]<val){
				begin=mid+1;
			}else if(arr[mid]>val){
				end=mid-1;
			}else{
				// 1,2,2,2,1
				// i j
				if(begin==mid) break;
				begin=mid;
			}
		}
		if(arr[end]==val)return end;
		if(arr[begin]==val)return begin;
		return -1;
	}



}
