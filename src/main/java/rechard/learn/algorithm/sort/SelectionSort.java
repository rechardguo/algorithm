package rechard.learn.algorithm.sort;

/**
 * 选择排序
 */
    public class SelectionSort {

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

    public static void main(String[] args) {
        int [] arr =SortUtil.generateArr(100);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("\r\n=============================");
        new SelectionSort().sort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
