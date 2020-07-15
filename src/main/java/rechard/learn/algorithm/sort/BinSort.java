package rechard.learn.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * 桶排序
 */
public class BinSort {

    @Test
    public void check(){
        for (int i = 0; i <10 ; i++) {
            int[] arr = SortUtil.generateArr(i);
            int[] arr2 = SortUtil.clone(arr);
            sort(arr);
            BubboSort.sort(arr2);
            Assert.assertArrayEquals(arr, arr2);
        }
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
                arr[index++]=i+min;
            }
        }
    }




}
