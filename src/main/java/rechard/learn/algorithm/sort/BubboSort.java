package rechard.learn.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * 冒泡排序
 * 时间复杂度：O(N^2)
 * 空间复杂度：O(N^2)
 * @author Rechard
 */
public class BubboSort {

    @Test
    public void check(){
        for (int i = 0; i <100 ; i++) {
            int[] arr = SortUtil.generateArr(i);
            int[] arr2 = SortUtil.clone(arr);
            sort(arr);
            BinSort.sort(arr2);
            Assert.assertArrayEquals(arr, arr2);
        }
    }

    public static void sort(int[]arr){
        for(int j=arr.length-1;j>0;j--){
            for(int i=0;i<j;i++){
                if(arr[i]>arr[i+1]){
                    int tmp=arr[i+1];
                    arr[i+1]=arr[i];
                    arr[i]=tmp;
                }
            }
        }
    }
}
