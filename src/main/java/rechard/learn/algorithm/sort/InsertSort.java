package rechard.learn.algorithm.sort;

/**
 * 插入排序,O(N^2)
 */
public class InsertSort {

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            int [] arr =SortUtil.generateArr(10);
            int [] arrCopy=SortUtil.clone(arr);
            sort(arr,0,arr.length);
            BubboSort.sort(arrCopy);
            if(!SortUtil.isEqual(arr,arrCopy)){
                SortUtil.print(arr);
                SortUtil.print(arrCopy);
                System.out.println("------------------------");
            }
        }
    }
    public static void sort(int arr[]){
        for(int i=1;i<arr.length;i++) {
            int j=i-1;
            int tmp=arr[i];
            while(j>=0&&arr[j]>tmp){
                //左边0-j的部分是从小到大有序的
                // tmp要招到0-j里那个index的值比tmp小，就插入到index+1
                // 在此过程中不断的移动
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=tmp;
        }
    }
    /**
     *
     * @param arr
     * @param left include
     * @param right exclude
     */
    public static void sort(int arr[],int left,int right){
        for(int i=left;i<right;i++) {
            int j=i-1;
            int tmp=arr[i];
            while(j>=left&&arr[j]>tmp){
                //左边0-j的部分是从小到大有序的
                // tmp要招到0-j里那个index的值比tmp小，就插入到index+1
                // 在此过程中不断的移动
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=tmp;
        }
    }

    /**
     * JDK 里的插入排序
     *
     */

    public static void jdkInsertionSort(int a[],int left,int right){
        for (int i = left, j = i; i < right; j = ++i) {
            int ai = a[i + 1];
            while (ai < a[j]) {
                a[j + 1] = a[j];
                if (j-- == left) {
                    break;
                }
            }
            a[j + 1] = ai;
        }
    }
}