package rechard.learn.algorithm.sort;

public class ShellSort {
	public static void main(String[] args) {
		for (int i=0;i<300;i++){
			int [] arr =SortUtil.generateArr(10);
			int [] arrCopy=SortUtil.clone(arr);
			sort(arr);
			BubboSort.sort(arrCopy);
			if(!SortUtil.isEqual(arr,arrCopy)){
				SortUtil.print(arr);
				SortUtil.print(arrCopy);
				System.out.println("------------------------");
			}
		}
	}
	public static  void sort(int[] arr){
		for(int gap = arr.length/2;gap>0;gap/=2){
			for(int i=gap;i<arr.length;i++){
				int j=i;
				while(j>=gap){
					if(arr[j]<arr[j-gap])
						swap(arr,j,j-gap);
					j-=gap;
				}
			}
		}
	}
	private static void swap(int[] arr, int i, int j) {
		arr[i]=arr[i]+arr[j];
		arr[j]=arr[i]-arr[j];
		arr[i]=arr[i]-arr[j];
	}
}
