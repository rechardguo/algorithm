package rechard.learn.algorithm;

import java.util.Stack;

public class CalTreeLength {
	
	public static void main(String[]args){
		TreeNode treeNode1 = new TreeNode(10);
		treeNode1.left = new TreeNode(5);
		treeNode1.left.left  = new TreeNode(3);
		treeNode1.right = new TreeNode(30);
		treeNode1.right.left = new TreeNode(20);
		treeNode1.right.right = new TreeNode(60);
		System.out.println(new CalTreeLength().TreeDepth(treeNode1));
	}
	
	static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;
	    public TreeNode(int val) {
	        this.val = val;

	    }
	}
	
	//递归写法
	public int TreeDepth2(TreeNode root) {
		if(root==null)
			return 0;
		int left = TreeDepth2(root.left);
		int right = TreeDepth2(root.right);
		return left>right?(left+1):(right+1);
	}
	
	public int TreeDepth(TreeNode root) {
        int curLength=0;
        int maxLength=0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode tmp = root;
        stack.push(tmp);
        curLength++;
        while(tmp!=null){
        	tmp=tmp.left;
            if(tmp==null && !stack.isEmpty()){
                tmp=stack.pop().right;
                maxLength=maxLength<curLength?curLength:maxLength;
            }else{
            	if(tmp.left!=null ||tmp.right!=null){
                  stack.push(tmp);
                  curLength++;
            	}
            }
            if(tmp==null && !stack.isEmpty()){
            	tmp=stack.pop();
                curLength--;
            }
        }
        return maxLength;
    }
}
