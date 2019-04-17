package rechard.learn.algorithm.sort;

/**
 * 冒泡排序 O(N^2)
 */
public class BubboSort {

    public static void main(String[] args) {
        int [] arr =SortUtil.generateArr(0);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        System.out.println("=============================");
        sort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
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
