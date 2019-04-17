package rechard.learn.algorithm.linkedlist;
/**
 * 不通过递归或栈将一个单链表反转
 * @author Rechard
 *
 */
public class ReverseLink {

	static class Node{
		private Object value;
		private Node next;
		public Node(Object value,Node next){
			this.value=value;
			this.next=next;
		}
		public Object getValue(){
			return this.value;
		}
	}
	
	public static void print(Node root){
		Node node = root;
		while(node!=null){
			System.out.println(node.getValue());
			node = node.next;
		}
	}

	public static Node reverse(Node root){
		if(root==null)
			return root;
		Node curNode = root;
		Node lastNode = null;
		Node curNodeNext = null;
		while(curNode!=null){
			curNodeNext = curNode.next;
			curNode.next = lastNode;
			lastNode = curNode;
			curNode = curNodeNext;
		}
		root.next = null;
		return lastNode;
	}

	public static void main(String[] args) {
		Node prev = new Node(0,null);
		for(int i=1;i<10;i++){
			prev = new Node(i,prev);
		}
		print(prev);
		Node reverseNode = reverse(prev);
		System.out.println("=============================");
		print(reverseNode);
	}

}
