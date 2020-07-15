package rechard.learn.leecode;


import java.io.IOException;

/**
 * 2数之和
 *  最早的解法受到了归并排序的影响
 *
 *  假设2个有序数组
 *  A[1,5,6]
 *  B[2,3,4]
 *
 *  借鉴了AddTwoNumbers里的解法，代码更加简洁
 */

public class AddTwoNumbers_thinkabout_mergesort {

    public static int[] merge(int [] arr1,int []arr2){
        //其中一个数组为空，就返回另个数组
        if (arr1 != null) {
            if (arr2 == null) {
                return arr1;
            }
            int l1 = 0, l2 = 0, index = 0;
            int[] result = new int[arr1.length + arr2.length];
            while (l1 < arr1.length || l2 < arr2.length) {
                if (l1 < arr1.length && l2 < arr2.length) {
                    result[index++] = arr1[l1] < arr2[l2] ? arr1[l1++] : arr2[l2++];
                } else {
                    result[index++] = l1 < arr1.length ? arr1[l1++] : arr2[l2++];
                }
            }
            return result;
        } else {
            return arr2;
        }
    }

    public static void main(String[] args) {
        int [] arr1=new int[]{5,9,10};
        int [] arr2=new int[]{6,8,9};
        int [] rs=merge(arr1,arr2);
        for (int i = 0; i < rs.length; i++) {
            System.out.println(rs[i]);
        }
    }

}
