package rechard.learn.algorithm;

public class Test2 {

	public static void main(String[] args) {
		int[] numArr = {1,2,2,3,3,3,4,4,4,4,5,5,5,5,5,6,6,6,6,6,6};
		int index =20;
		int num = calIndexNum(numArr,index);
		System.out.println("index="+index+", result is : " + num);
	}

	private static int calIndexNum(int[] numArr, int index) {
		if(index<=0)
			throw new RuntimeException("index can not be negative");
		if(index>numArr.length)
			throw new RuntimeException("index can not be lager than numArr length");
		int count = 1;
		int sum = 0;
		while(sum<index){
			sum += count;
			count++;
		}
		if(sum==index)//sum==index
			return count-1;
		else{//sum>index
			if(sum-(count-1)<=index){
				return count-1;
			}else{
				return count-1-1;
			}
		}
		
	}
}
