package rechard.learn.algorithm;

public class MergeLinkNodeDemo {

	static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
	/**
	 * 未能在规定时间内运行结束，请检查是否循环有错或算法复杂度过大
	 * 测试用例:
{1,3,5},{2,4,6}

对应输出应该为:

{1,2,3,4,5,6}

	 * @param list1
	 * @param list2
	 * @return
	 */
	public ListNode Merge(ListNode list1,ListNode list2) {
		ListNode headNode = null;
		ListNode preNode = null;
		ListNode tmpNode = null;
		while(list1!=null || list2!=null){
			if(list1 !=null && list2!=null){
				if(list1.val<list2.val){
					tmpNode = list1;
					list1 = list1.next;
				}else{
					tmpNode = list2;
					list2 = list2.next;
				}
			}else if(list2!=null){
				tmpNode = list2;
				list2 = list2.next;
			}else{
				tmpNode = list1;
				list1 = list1.next;
			}
			
			if(headNode == null) 
				headNode = tmpNode;
			else{
				preNode.next = tmpNode;   
			}
			preNode = tmpNode;
		}
		return headNode;
	}
}
