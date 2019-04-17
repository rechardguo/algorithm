package rechard.learn.algorithm.sort;

import java.util.Random;

public class HeapSort {
    //堆排序
    public static  int[] sort(int[] arr) {
        int[] arr2 = arr;
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr2, i,arr[i]);
        }
        heapify(arr2);
        return arr2;
    }


    private static void heapify(int[] arr2) {
        int heapSize=arr2.length-1;
        while(heapSize>0) {
            int index=0;
            swap(arr2,index,heapSize--);
            while(index<heapSize) {
                int left = 2 * index + 1;
                int right = left + 1;
               
                int maxChildIndex = right;
                if(left>heapSize-1)
                   break;
                else if(right>heapSize-1)
                    maxChildIndex=left;
                else
                    maxChildIndex=arr2[left] > arr2[right] ? left : right;  
              
                if (arr2[maxChildIndex] > arr2[index]) {
                    swap(arr2, maxChildIndex, index);
                    index=maxChildIndex;
                }
            }
        }
    }

    //大根堆
    private static void heapInsert(int[] arr2,int index, int value) {
        arr2[index]=value;
        int parent = arr2[(index-1)/2];
        while(parent<value){
            swap(arr2,index,(index-1)/2);
            index=(index-1)/2;
            parent=arr2[(index-1)/2];
        }
    }
    
    private static void swap(int[] arr, int i, int j) {
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }

    public static void main(String[] args) {
        int [] arr =generateArr(20);
        int [] arr2 = arr;
        QuickSort.quickSort(arr2,0,arr2.length-1);
        int[] arr3 = sort(arr);
        System.out.println(isEqual(arr2,arr3));
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

    public  static int[] generateArr(int i){
        int arr[] = new int[i];
        Random r = new Random();
        for(int j=1;j<i;j++)
            arr[j]= r.nextInt(j*100);
        return arr;
    }
}
