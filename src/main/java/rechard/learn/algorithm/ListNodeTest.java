package rechard.learn.algorithm;

import java.util.ArrayList;
import java.util.Stack;

public class ListNodeTest {


	private static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
	
	
	 public ListNode FindKthToTail(ListNode head,int k) {
	        if(head==null) return null;
	        if(k<1) return null;
	        ListNode e = head;
	        for(int i=1;i<k;i++){
	            if(head.next!=null)
	             e = head.next;
	            else 
	             return null; 
	        }
	        
	        ListNode f = head;
	        while(e!=null){
	            e=e.next;
	            f=f.next;
	        }
	        return f;
	    }
	
	/**
	 * 运行超时:您的程序未能在规定时间内运行结束，请检查是否循环有错或算法复杂度过大。
	 */
	ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead4(ListNode listNode) {
        if(listNode==null)
			return list;
        if(listNode.next!=null){
			printListFromTailToHead4(listNode.next);
		}     
		list.add(listNode.val);
		return list;
    }
	
	/**
	 * 编译错误:您提交的代码无法完成编译
./Solution.java:15: error: cannot find symbol
Stack stack = new Stack();
	 * @param listNode
	 * @return
	 */
	public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
		/*Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(listNode==null)
			return list;
		ListNode tmp = listNode;
		do{
			stack.push(tmp.val);
		}while((tmp=listNode.next)!=null);
		
		while(!stack.isEmpty()){
			list.add(stack.pop());
		}
		return list;*/
		
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(listNode!=null){
			stack.push(listNode.val);
			listNode=listNode.next;			
		}
		while(!stack.isEmpty()){
			list.add(stack.pop());
		}
		return list;
	}
	/**
	 * 运行超时:您的程序未能在规定时间内运行结束，请检查是否循环有错或算法复杂度过大。
	 * @param listNode
	 * @return
	 */
	public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(listNode==null)
			return list;
		ListNode tmp = listNode;
		do{
			list.add(0,tmp.val);
		}while((tmp=listNode.next)!=null);
		return list;
	}
	
	/**
	 * 运行超时:您的程序未能在规定时间内运行结束，请检查是否循环有错或算法复杂度过大。
	 * @param listNode
	 * @return
	 */
	public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		if(listNode==null)
			return list2;
		
		while(listNode.next!=null){
			list.add(listNode.val);
		}
		
		for (int i=list.size();i>0;i--) {
			list2.add(list.get(i));
		}
		return list2;
	}

	public static void main(String[] args) {
		

	}

}
