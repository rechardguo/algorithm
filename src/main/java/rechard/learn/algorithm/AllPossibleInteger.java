package rechard.learn.algorithm;

import java.util.Arrays;

public class AllPossibleInteger {

	public static void main(String[]args){
		int[] ints={3,4,5,7,8,10};
		System.out.println(new AllPossibleInteger().getResult(ints));
	}
	
	public String  getResult(int[] ints){
		if(ints.length==0)
			return "misstake";
		else if(ints.length==1)
			return (ints[0]-1)+","+(ints[0]+1);
		else{
			sort(ints);
			int missMark=0;
			int expVal=ints[0];
			String missValue=null;
			for(int i=0;i<ints.length;i++){
				 if(expVal!=ints[i]){
					 missMark++;
					 if(missMark==1){
						 missValue=expVal+"";
						 expVal+=2;
					 }else{
						return "misstake";
					}
				 }else{
					 expVal++;
				 }
			}
			if(missMark==0)
				return (ints[0]-1)+","+(ints[ints.length-1]+1);
			else 
 				return missValue;
			
		}
	}
	
	//todo sort algorithm chose
	public void sort(int[] ints){
		Arrays.sort(ints);
	}
	
}
