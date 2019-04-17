package rechard.learn.jzoffer;

public class FindSmallerNumber {

	public static void main(String[]args){
		int[] arr4 = new int[]{};
		System.out.println(findSmallestNumer(arr4));
		
		int[] arr = new int[]{4,5,6,7,1,2,3};
		System.out.println(findSmallestNumer(arr));


		int[] arr2 = new int[]{4,5,6,7,8,9,10};
		System.out.println(findSmallestNumer(arr2));
		
		
		int[] arr3 = new int[]{1,1,1,0,1,1,1};
		System.out.println(findSmallestNumer(arr3));
		System.out.println(findMinNumber(arr3));
	}
	
	
	 public int minNumberInRotateArray(int [] array) {
		 if(array==null || array.length==0)
			 return 0;
		 
		 
		 
		 return -1;
	 }
	
	//二分查找
	public static int findMinNumber(int[] arr){
		if(arr==null || arr.length==0)
			throw new RuntimeException("int arrary can not be null or empty");
		
		if(arr.length==1)
			return arr[0];
		
		int low = 0;
		int hight = arr.length-1;
		int mid=low;
		while(arr[low]>=arr[hight] && low>=hight){
			
			mid = low+(hight-low)/2;
			
			if(arr[mid]>=arr[low])
				low=mid;
			else if(arr[mid]<=arr[hight])
				hight=low;
			
			
		}
		
		return arr[mid];
		
	}
	

	public static int  findSmallestNumer(int[] arr){
		if(arr==null || arr.length==0)
         return 0;
		
		if(arr.length==1)
			return arr[0];
		
		int smaller = arr[arr.length-1];
		int i = 0;
		int j = arr.length-1;
		
		while(arr[i]>=arr[j] && i<=j){
			smaller=arr[j];
			i++;
			j--;
		}
		
		
		if(arr[i]<arr[j])
			return arr[i];
		
		return smaller;
		
	}
	
	public int JumpFloorII(int target) {
        if(target==1){ 
            return 1;
        }else{
            return 2*JumpFloorII(--target);
        }
    }
}

