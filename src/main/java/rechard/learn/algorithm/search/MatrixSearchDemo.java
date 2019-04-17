package rechard.learn.algorithm.search;

import rechard.learn.algorithm.search.BinarySearch;

/**
 * 二维数组中的查找
在一个二维数组中，每一行都按照从左到右递增的顺序排序，
每一列都按照从上到下递增的顺序排序。请完成一个函数，
输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。


思路： 二分查找夹逼 找 到row_index,再在intMatix[row_index]用二分查找 找
 时间复杂度 	2O(log2n)
 * @author Rechard
 *
 */
public class MatrixSearchDemo {

	public static void main(String[] args) {

		int[][] intMatrix = {
				{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,18},
				{20,23,28,29,30},
				{120,123,128,129,130},
				{220,223,228,229,230}
		};

		System.out.println(find(intMatrix,250));

	}


	public boolean Find(int target, int [][] array) {
        int row =0;
		int col = array.length-1;
		while(col>=0 && row<array[col].length){
			if(array[row][col]>target){
				col--;
			}else if(array[row][col]<target){
				row++;
			}else{
				return true;
			}
		}
		return false;
    }


	static  String find(int[][] intMatrix,int number){
		if(intMatrix==null)
			return null;
		//to do : make sure not have out of index exception
		int lo_row_index = 0;
		int hi_row_index = intMatrix.length-1;
		int target_row_index = 0;
		while(lo_row_index<hi_row_index){
			target_row_index = lo_row_index+(hi_row_index-lo_row_index)/2;
			int mi_row_val = intMatrix[target_row_index][0];
			if(mi_row_val>number){
				hi_row_index =  target_row_index-1;
			}else if(mi_row_val==number){
				return target_row_index+",0";
			}else{
				lo_row_index = target_row_index+1;	
			}
		}
		//close to number row 
		if(intMatrix[target_row_index][0]>number)
			target_row_index = target_row_index-1;
		else if (intMatrix[target_row_index][intMatrix[target_row_index].length-1]==number)
			return target_row_index+","+target_row_index+intMatrix[target_row_index].length;
		else if (intMatrix[target_row_index][intMatrix[target_row_index].length-1]<number)
			target_row_index = target_row_index+1;

		if(target_row_index<0 || target_row_index>intMatrix[target_row_index].length)
			return "not found";

		int column_index = BinarySearch.binarysearch(intMatrix[target_row_index], number);
		if(column_index==-1)
			return "not found";

		return target_row_index+","+column_index;
	}

}


