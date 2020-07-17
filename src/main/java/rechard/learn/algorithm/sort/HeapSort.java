package rechard.learn.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * 堆排序
 *
 *
 * @author Rechard
 *
 *
 */

public class HeapSort {


    @Test
    public void check() {
        for(int i=0;i<100;i++) {
            int[] arr = SortUtil.generateArr(5);
            int[] arr2 = SortUtil.clone(arr);
            arr = sort(arr);
            BubboSort.sort(arr2);
            Assert.assertArrayEquals(arr, arr2);
        }
    }

    //堆排序
    public static  int[] sort(int[] arr) {

        int[] newArr=new int[arr.length];
        // 大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(newArr, i,arr[i]);
        }
        heapify(newArr);
        return newArr;
    }

    /**
     * arr 传入的是个大根堆
     * 但不是有序的，需要进行排序，排序的步骤：
     *
     * 1. 将堆顶的元素和末尾的交换
     *
     * @param arr
     */

    private static void heapify(int[] arr) {
        int heapSize=arr.length-1;
        while(heapSize>0) {
            int index=0;
            swap(arr,index,heapSize--);
            while(index<heapSize) {
                int left = 2 * index + 1;
                int right = left + 1;

                int maxChildIndex = left;
                if(left>heapSize)
                    break;
                if(right<=heapSize)
                    maxChildIndex=arr[left] > arr[right] ? left : right;

                if (arr[maxChildIndex] > arr[index]) {
                    swap(arr, maxChildIndex, index);
                }
                index=maxChildIndex;
            }
        }
    }

    //大根堆

    /**
     *  每次将元素插入到数组尾部，然后和它的父类比较，如果父类小于自己，则交换
     *  直到根元素
     * @param arr
     * @param index
     * @param value
     */
    private static void heapInsert(int[] arr,int index, int value) {
        arr[index]=value;
        if(index==0)return;
        //借鉴了priorityqueue里的写法，找出父类的index
        int parentIndex=(index-1)>>>1;
        int parentValue = arr[parentIndex];
        //如果父类小于自己则不断交换
        while(parentValue<value){
            //交换
            swap(arr,index,parentIndex);
            //交换完后将自己当成parentValue
            //注意不要写成value=parentValue,因为parentValue没因为swap(arr,index,parentIndex)改变
            value=arr[parentIndex];

            //index变成parentIndex
            index=parentIndex;
            //parentIndex则需要改成改后的index的父类
            parentIndex=(index-1)<0?0:(index-1)>>>1;
            parentValue=arr[parentIndex];
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }


}
