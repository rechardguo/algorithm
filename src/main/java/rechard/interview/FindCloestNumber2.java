package rechard.interview;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 在一个有序数组中找到target的begin和end
 * 例如  1,3,3,3,3,3,8 ，target=3 则返回 1,5
 *
 * O(logn)
 */
public class FindCloestNumber2 {

    public static int[] solution(int[] arr,int target){
        if(arr==null){
            return new int[]{-1,-1};
        }
        //找到最接近的index
        int cloesetIndex=binarySearch(arr,0,arr.length-1,target);

        int cloesetNumber;
        //如果index超出范围就是没找到
        //如果在范围内，要判断下index是否就是找到target
        if(cloesetIndex>arr.length-1 || cloesetIndex<0 || (cloesetNumber=arr[cloesetIndex])!=target)
            return new int[]{-1,-1};
        //二分查找左边的边界
        int left=cloesetIndex;
        while(left>0 && arr[left]==target){
            int mid=binarySearch(arr, 0, left,target);
            if(mid==left) break;
            else left=mid;
        }
        //二分查找右边的边界
        int right=cloesetIndex;
        while(right<arr.length && arr[right]==target) {
            int mid=binarySearch(arr,right,arr.length-1,target);
            if(mid==right) break;
            else right=mid;
        };
        return new int[]{left,right};
    }

    private static int binarySearch(int[] arr,int from,int end, int target) {
        int i=from;
        int j=end;
        int mid=(i+j)/2;
        //二分查找，找到最接近target的index
        while(i<=j){
            if(arr[mid]>target){
                j=mid-1;
            }else if(arr[mid]<target){
                i=mid+1;
            }else{
                break;
            }
            mid=i+(j-i)/2;
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{1,3,3,3,3,3,8};
        int[] result=solution(arr,7);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
