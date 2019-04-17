package rechard.learn.algorithm.btree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 树的前序，中序，后序遍历
 */
public class TreeTravel {
	public List<TreeNode> pre_Travel(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<TreeNode> l = new ArrayList<TreeNode>();
		TreeNode node = root;
		stack.push(node);
		while(!stack.isEmpty()){
			l.add(node=stack.pop());
			if(node.right!=null)
				stack.push(node.right);
			if(node.left!=null)
				stack.push(node.left);
		}
		return l;
	}
	
	public List<TreeNode> mid_Travel(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<TreeNode> l = new ArrayList<TreeNode>();
		TreeNode node = root;
		while(node!=null || !stack.isEmpty()){
			if(node!=null) {
				stack.push(node);
				node = node.left;
			}else{
				 l.add(node=stack.pop());
				 node=node.right;
			}
		}
		return l;
	}

	/**
	 *
	    10
	   5   30
	 3    20  60
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode treeNode1 = new TreeNode(10);
		treeNode1.left = new TreeNode(5);
		treeNode1.left.left  = new TreeNode(3);
		treeNode1.right = new TreeNode(30);
		treeNode1.right.left = new TreeNode(20);
		treeNode1.right.right = new TreeNode(60);
				
		List<TreeNode> list = new TreeTravel().mid_Travel(treeNode1);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).val);
		}
		System.out.println("====================================================");
		List<TreeNode> list2 = new TreeTravel().pre_Travel(treeNode1);
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i).val);
		}
	}

}
