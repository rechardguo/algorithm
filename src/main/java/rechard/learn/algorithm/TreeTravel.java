package rechard.learn.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import rechard.learn.algorithm.SubtreeCheckDemo.TreeNode;

public class TreeTravel {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public List<TreeNode> mid_Travel(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<TreeNode> l = new ArrayList<TreeNode>();
		TreeNode node = root;
		stack.push(node);
		while(node!=null || !stack.isEmpty()){
			if(node!=null)
				node = node.left;
			else{
				 l.add(node=stack.pop());
				 node=node.right;
			}
			if(node!=null)
				stack.push(node);
		}
		return l;
		
	}
	
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
	}

}
