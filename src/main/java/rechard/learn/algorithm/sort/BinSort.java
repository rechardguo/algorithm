package rechard.learn.algorithm.sort;

import java.util.Random;

/**
 * 桶排序
 */
public class BinSort {

    public static void main(String[] args) {
        int [] arr =generateArr(5);
        int [] arr2 = arr;
        sort(arr);
        QuickSort.quickSort(arr2,0,arr2.length-1);
        System.out.println(isEqual(arr,arr2));
    }

    public static void sort(int arr[]){
        if(arr==null || arr.length==0)
            return;
        int min=arr[0] ;
        int max=arr[0];
        for(int i=0;i<arr.length;i++){
          min =Math.min(min,arr[i]);
          max =Math.max(max,arr[i]);
        }
        int [] buckets=new int[max-min+1];
        for(int i=0;i<arr.length;i++){
            buckets[arr[i]-min]++;
        }
        int index=0;
        for(int i=0;i<buckets.length;i++){
            while(buckets[i]-->0){
                arr[index++]=i;
            }
        }
    }


    public  static int[] generateArr(int i){
        int arr[] = new int[i];
        Random r = new Random();
        for(int j=1;j<i;j++)
            arr[j]= r.nextInt(j*100);
        return arr;
    }

    //判断两个数组是否相等
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null))
            return false;
        if(arr1 == null && arr2 == null)
            return true;
        if(arr1.length != arr2.length)
            return false;
        for(int i = 0;i < arr1.length;i++) {
            if(arr1[i] != arr2[i])
                return false;
        }
        return true;
    }
}
