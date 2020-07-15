package rechard.learn.algorithm.sort;

import java.util.Random;

public class Utils {
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
