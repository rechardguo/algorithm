package rechard.learn.algorithm.sort;

import java.util.Random;

public class SortUtil {
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
        for(int j=0;j<i;j++)
            arr[j]= r.nextInt((j+1)*100);
        return arr;
    }

    public static void print(int[] arr){
        for (int i = 0; i <arr.length; i++) {
            System.out.print(arr[i]);
            if(i<arr.length-1)
            System.out.print(",");
        }
        System.out.println("");
    }

    /**
     * 用于复制一份int[]
     * @param arr
     * @return
     */
    public  static int[] clone(int[] arr){
        int[] dest=new int[arr.length];
        System.arraycopy(arr,0,dest,0,arr.length);
        return dest;
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}
