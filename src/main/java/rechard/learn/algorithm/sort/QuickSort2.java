package rechard.learn.algorithm.sort;
public class QuickSort2 {
	public static void main(String[]args){
		for (int i=0;i<300;i++){
			int [] arr =SortUtil.generateArr(10);
			int [] arrCopy=SortUtil.clone(arr);
			sort(arr,0,arr.length-1);
			BubboSort.sort(arrCopy);
			if(!SortUtil.isEqual(arr,arrCopy)){
				SortUtil.print(arr);
				SortUtil.print(arrCopy);
				System.err.println("------------------------");
			}
		}
	}

	public static void sort(int[]arr,int lo,int hi){
		if(lo>=hi)
			return;
		int p=arr[lo];
		int i=lo;
		int j=hi+1;
		while(i<j){
			while(++i<hi && arr[i]<p); // 由于轴是lo,所以++i可以跳过lo，找到比p大的数
			while(--j>lo && arr[j]>p); //hi+1 则可以使用--j，找到比p小的数
			if(i>=j)
				break;
			//交换
			int t=arr[i];
			arr[i]=arr[j];
			arr[j]=t;
		}
		arr[lo]=arr[j];
		arr[j]=p;
		sort(arr,lo,j-1);
		sort(arr,j+1,hi);
	}
}
