package rechard.interview;

import java.util.ArrayList;
import java.util.List;

public class FindCloestNumber {

    public List<Integer> solution(int[] arr,int target){
        List l=new ArrayList<>();
        if(arr==null){
            l.add(-1);
            return l;
        }
        int i=0;
        int j=arr.length-1;
        int mid=i+j/2;
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
        //找到最接近的index的值
        int cloestNumber=arr[mid];
        //求出最接近的数和target之间的差值
        int cha=Math.abs(target-cloestNumber);
        i=mid;
        //以mid为起点往左边找到所有差值相同的元素,加入list
        while(i>=0 && Math.abs(arr[i]-target)==cha){
            l.add(0,i); //为使返回的结果有序，这里add index=0
            i--;
        }
        i=mid+1;
        //以mid+1为起点往右边找到所有差值相同的元素,加入list
        while(i<arr.length && Math.abs(arr[i]-target)==cha){
            l.add(i);
            i++;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{1,3,3,4};
        List<Integer> l=new FindCloestNumber().solution(arr,2);
        for (Integer i:l){
            System.out.println(i);
        }
        System.out.println("----------------------");
        arr=new int[]{1,4,6};
        l=new FindCloestNumber().solution(arr,5);
        for (Integer i:l){
            System.out.println(i);
        }
        System.out.println("----------------------");
        arr=new int[]{1,2,3};
        l=new FindCloestNumber().solution(arr,2);
        for (Integer i:l){
            System.out.println(i);
        }
    }
}
