package rechard.learn.algorithm;

public class ShellSort {
	public static void main(String[] args) {
		int[] arr = new int[]{5,2,9,4,1,6};
		new ShellSort().sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	public void sort(int[] arr){
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
	private void swap(int[] arr, int i, int j) {
		/*arr[i]=arr[i]^arr[j];
		arr[j]=arr[j]^arr[i];
		arr[i]=arr[i]^arr[j];*/
		arr[i]=arr[i]+arr[j];
		arr[j]=arr[i]-arr[j];
		arr[i]=arr[i]-arr[j];
	}
}
