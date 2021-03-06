package rechard.learn.algorithm.search;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
 * @author Rechard
 *
 */
public class BinarySearchAdvance {
	@Test
	public  void check() {
		int[] arr=new int[]{1,2,2,2,3};
		Assert.assertArrayEquals(new int[]{0,0},binarysearch(arr,1));
		Assert.assertArrayEquals(new int[]{1,3},binarysearch(arr,2));
		Assert.assertArrayEquals(new int[]{4,4},binarysearch(arr,3));
		Assert.assertArrayEquals(new int[]{-1,-1},binarysearch(arr,4));
	}

	public int[] binarysearch(int []arr ,int val){
		if(arr==null) return null;
		int left =left_bound(arr,val);
		int right=right_bound(arr,val);
		if(left==right)
		  return new int[]{left,right};
		else
			return left==-1? new int[]{right,right}:right==-1?new int[]{left,left}:new int[]{left,right};
	}
	// 1 2 2 2 2 3
	// l   m     r
	// l r
	int left_bound(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else if (nums[mid] == target) {
				// 别返回，锁定左侧边界
				right = mid - 1;
			}
		}
		// 最后要检查 left 越界的情况
		if (left >= nums.length || nums[left] != target)
			return -1;
		return left;
	}
	int right_bound(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else if (nums[mid] == target) {
				// 别返回，锁定右侧边界
				left = mid + 1;
			}
		}
		// 最后要检查 right 越界的情况
		if (right < 0 || nums[right] != target)
			return -1;
		return right;
	}
/*

	public int left(int[]arr ,int val){
		int left=0,right=arr.length-1;
		while(left<=right){
			int mid=left+(right-left>>1);
			if(arr[mid]<val){
				left=mid+1;
			}else if(arr[mid]>val){
				right=mid-1;
			}else{
				left=mid+1;   // 别返回，锁定右侧边界
			}
		}
		if(right>=arr.length)
		return -1;
	}
	public int right(int[]arr ,int val){
		int i=0,j=arr.length-1;
		while(i<=j){
			int mid= i+(j-i>>1);

			if(arr[mid]<val){
				i=mid+1;
			}else if(arr[mid]>val){
				j=mid-1;
			}else{
				// 1,2,2,2,1
				// i j
				if(i==mid) break;
				i=mid;
			}
		}
		if(arr[j]==val)return j;
		if(arr[i]==val)return i;
		return -1;
	}*/



}
