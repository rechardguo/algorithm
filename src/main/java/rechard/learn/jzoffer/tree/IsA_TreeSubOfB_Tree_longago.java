package rechard.learn.jzoffer.tree;

public class IsA_TreeSubOfB_Tree_longago {
	static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;
	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	public boolean HasSubtree(TreeNode root1,TreeNode root2) {
		boolean flag = true;
		if(root1==null)
			return false;
		if(root2==null)
		    return false;
		TreeNode findRoot = root1;
		while(findRoot!=null){
			if(findRoot.val<root2.val)
				findRoot = findRoot.right;
			else if(findRoot.val>root2.val)
				findRoot = findRoot.left;
			else{
				break;
			}
		}
		if(findRoot==null)
		 	 flag = false;
		else
			flag = isSubTree(findRoot,root2);
		return flag;
    }
	
	private boolean isSubTree(TreeNode root1,TreeNode root2){
		boolean flag =true;
		if(root2 == null)
			return true;
		if(root1 == null)
			return false;
		flag =  flag?(flag&isSubTree(root1.left,root2.left)):false;
		flag =  flag?(flag&isSubTree(root1.right,root2.right)):false;
		return flag?(root1.val == root2.val):false;
	}

	//{8,8,7,9,2,#,#,#,#,4,7},{8,9,2}
	public static void main(String[] args) {
		TreeNode treeNode1 = new TreeNode(10);
		treeNode1.left = new TreeNode(5);
		treeNode1.left.left  = new TreeNode(3);
		treeNode1.right = new TreeNode(30);
		treeNode1.right.left = new TreeNode(20);
		treeNode1.right.right = new TreeNode(60);
		
		TreeNode treeNode2 = new TreeNode(5);
		treeNode2.left = new TreeNode(3);
		System.out.println(new IsA_TreeSubOfB_Tree_longago().HasSubtree(treeNode1,treeNode2));
		
		treeNode2 = new TreeNode(5);
		treeNode2.left = new TreeNode(3);
		treeNode2.right =  new TreeNode(20);
		System.out.println(new IsA_TreeSubOfB_Tree_longago().HasSubtree(treeNode1,treeNode2));
	}
}
