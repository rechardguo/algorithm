package rechard.interview;

import java.util.ArrayList;
import java.util.List;
/* 在一个有序数组中找到target最接近的index集合
        * 例如  1,3,3,4 ，target=3 则返回 1,2
        * 例如  1,3,3,4 ，target=2 则返回 0,1,2
        * 例如  1,3,3,4 ，target=-1 则返回 0
        * 例如  1,3,3,4 ，target=8 则返回 3
        */
public class FindCloestNumber {

    //o(n)+o(logn)
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
        if(mid<0) mid=0;
        if(mid>arr.length-1) mid=arr.length-1;

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

   //o(logn)
    public List<Integer> solution_2(int[] arr,int target){
        List l=new ArrayList<>();
        if(arr==null){
            l.add(-1);
            return l;
        }
        int mid = getMid(arr,0,arr.length-1, target);
        if(mid<0) mid=0;
        if(mid>arr.length-1) mid=arr.length-1;

        int cloestNumber=arr[mid];
        int cha=Math.abs(target-cloestNumber);
        int leftBoundary=getMid(arr,0,mid,target-cha);
        int rightBoundary=getMid(arr,mid,arr.length-1,target+cha);
        for(int i=leftBoundary;i<=rightBoundary;i++)
            l.add(i);
        return l;
    }

    private int getMid(int[] arr,int begin,int end, int target) {
        int i=begin;
        int j=end;
        int mid=i+(j-i)/2;
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
        int[] arr=new int[]{1,3,3,4};
        List<Integer> l=new FindCloestNumber().solution_2(arr,2);
        for (Integer i:l){
            System.out.println(i);
        }
        System.out.println("----------------------");
        arr=new int[]{1,4,6};
        l=new FindCloestNumber().solution_2(arr,5);
        for (Integer i:l){
            System.out.println(i);
        }
        System.out.println("----------------------");
        arr=new int[]{1,2,3};
        l=new FindCloestNumber().solution_2(arr,2);
        for (Integer i:l){
            System.out.println(i);
        }
    }
}
