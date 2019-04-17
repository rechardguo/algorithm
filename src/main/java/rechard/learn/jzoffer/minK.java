package rechard.learn.jzoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
/**
 * 牛客网
 * 最小的K个数
 * @author Rechard
 *
 */
public class minK {
	
	public static void main(String[] args) {
		int[] input = new int[]{4,5,1,6,2,7,3,8};
		ArrayList<Integer> result = new minK().GetLeastNumbers_Solution(input,9);
		for (Iterator iterator = result.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			System.out.println(integer);
		}
	}
	
	
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		ArrayList<Integer> list = new ArrayList(k);
		if(k>input.length)
		return list;
		GetLeastNumbers_Solution(input,k,list);
		return list;
	}
	
	public void GetLeastNumbers_Solution(int [] input, int k,ArrayList<Integer> list) {
		if(input==null||input.length==0)
			return ;
		int i=0;
		int j=input.length-1;
		int flag=input[0];
		Boolean isFrontMove =false;
		while(i<j){
			if(!isFrontMove){
				if(input[j]<flag){
					input[i]=input[j];
					isFrontMove=true;
				}else{
					j--;
				}
			}else{
				if(input[i]>flag){
					input[j]=input[i];
					isFrontMove=false;
				}else{
					i++;
				}
			}
		}
		input[i]=flag;
		if(i==k-1){
			for(int x=0;x<=i;x++){
				list.add(input[x]);
			}
			return;
		}else if(i<k-1){
			for(int x=0;x<=i;x++){
				list.add(input[x]);
			}
			int[] right = Arrays.copyOfRange(input,i+1,input.length);
			GetLeastNumbers_Solution(right,k-i-1,list);
		}else{
			int[] left = Arrays.copyOfRange(input,0,i);
			GetLeastNumbers_Solution(left,k,list);
		}
	}

}
