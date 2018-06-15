package rechard.learn.algorithm;

/**
 * 二分查找的原理就是夹逼算法
 * @author Rechard
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = new int[]{1,2,3,4,5,6};
		System.out.println(binarysearch(arr,6));
	}
	
	public static int binarysearch(int []arr ,int val){
		if(arr==null || arr.length==0)
			return -1;
		int begin=0;
		int end=arr.length-1;
		while(begin<=end){
			int index = begin+(end-begin)/2;
			if(arr[index]>val){
				end = index-1;
			}else if(arr[index]<val){
				begin = index+1;
			}else{
				return index;
			}
		}
		return -1;
	}

}
