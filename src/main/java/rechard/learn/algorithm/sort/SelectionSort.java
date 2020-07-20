package rechard.learn.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * 选择排序
 */
    public class SelectionSort {

    @Test
    public  void check(){
        for(int i=0;i<100;i++) {
            int[] arr = SortUtil.generateArr(i);
            int[] arr2 = SortUtil.clone(arr);
            sort(arr);
            BubboSort.sort(arr2);
            Assert.assertArrayEquals(arr, arr2);
        }
    }

    /**
     * 左边是有序的，i为有序的边界，每次从右边选择最小的元素,然后和i交换位置后i++
      * @param arr
     */
    public void sort(int[] arr){
            for (int i = 0; i <arr.length ; i++) {
                int min=i;
                for(int j=i;j<arr.length;j++){
                    if(arr[j]<arr[min]){
                        min=j;
                    }
                }
                int tmp=arr[i];
                arr[i]=arr[min];
                arr[min]=tmp;
            }
        }

}
