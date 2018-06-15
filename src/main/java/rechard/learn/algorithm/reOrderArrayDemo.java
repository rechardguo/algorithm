package rechard.learn.algorithm;

import java.util.Arrays;

public class reOrderArrayDemo {
	public void reOrderArray(int [] array) {
		int oddNum = 0 ;
		for(int i=0;i<array.length;i++){
			if(array[i]%2!=0) 
				oddNum++;
		}
		/*int [] array2 = Arrays.copyOf(array, array.length);*/
		int [] array2 = array.clone();
		int frontIndex = 0;
		int endIndext = oddNum;
		for(int i=0;i<array2.length;i++){
			if(array2[i]%2!=0){ 
				array[frontIndex++] = array2[i];
			}else{
				array[endIndext++] = array2[i];
			}
		}
	}
	
	public static void main(String[]args){
		int [] ints = new int[]{1,2,3,4,5,6,7};
		new reOrderArrayDemo().reOrderArray(ints);
	}
}
