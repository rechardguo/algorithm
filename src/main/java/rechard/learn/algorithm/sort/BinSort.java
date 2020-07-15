package rechard.learn.algorithm.sort;

import java.util.Random;

/**
 * 桶排序
 */
public class BinSort {

    public static void main(String[] args) {
        int [] arr =Utils.generateArr(5);
        int [] arr2 = arr;
        sort(arr);
        QuickSort.quickSort(arr2,0,arr2.length-1);
        System.out.println(Utils.isEqual(arr,arr2));
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




}
