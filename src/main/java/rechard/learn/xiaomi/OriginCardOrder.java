package rechard.learn.xiaomi;

import java.util.LinkedList;
/**
 * 一副从1到n的牌，每次从牌堆顶取一张放桌子上，再取一张放牌堆底，直到手上没牌，
 * 最后桌子上的牌是从1到n有序，设计程序，输入n，输出牌堆的顺序数组。
 * @author Rechard
 *
 */
public class OriginCardOrder {

	public static void main(String[] args) {

		int[] origCards = getOriginOrder(20);
		for (int i = 0; i < origCards.length; i++) {
			System.out.print(origCards[i]+" , ");
		}
		System.out.println("");
		System.out.println("=======================================");
		Integer[] origCards2 = getOriginOrder2(20);
		for (int j = 0; j < origCards2.length; j++) {
			System.out.print(origCards2[j]+" , ");
		}
	}

	public static int[] getOriginOrder(int n){
		int arr[] = new int[2*n];
		int lastCard =2*n-1,
		  firstCard =2*n-1;
		for(int i=1;i<=n;i++){
			arr[firstCard]=i;
			if(i!=n){
			firstCard--;
			arr[firstCard]=arr[lastCard];
			arr[lastCard]=0;
			lastCard--;
			firstCard--;
			}
		}
		int dest[] =new int[n];
		 System.arraycopy(arr, firstCard, dest, 0, lastCard-firstCard+1);
		 return dest;
	}
	
	public static Integer[] getOriginOrder2(int n){
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=1;i<=n;i++){
			list.push(i);
			if(i!=n){
				int lastCardNumber = list.removeLast();
				list.push(lastCardNumber);
			}
		}
		Integer[]  arr = new Integer[n];
		 list.toArray(arr);
		 return arr;
	}

}
