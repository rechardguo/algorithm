package rechard.learn.algorithm.btree;

import java.util.Arrays;

public class TreeRetriveDemo {
	//pre=[1,2,3,4,5,6,7], in = [3,2,4,1,6,5,7]
	public TreeNode reConstructBinaryTree2(int [] pre,int [] in) {
		if(pre==null || pre.length==0 ||in==null || in.length==0)
			return null;
		TreeNode root = new TreeNode(pre[0]);
		for(int i=0;i<in.length;i++){
			if(in[i] == root.val){
				int leftTreeNum= i;
				root.left = reConstructBinaryTree2(Arrays.copyOfRange(pre, 1, leftTreeNum+1),Arrays.copyOfRange(in,0,leftTreeNum));
				root.right = reConstructBinaryTree2(Arrays.copyOfRange(pre, leftTreeNum+1, pre.length),Arrays.copyOfRange(in,leftTreeNum+1,pre.length));
			}
		}
		return root;
    }
	
	/**
	 * 我的结题答案，思路是一样的，只是别人的更好，为什么不通过
	 * @param pre
	 * @param in
	 * @return
	 */
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
	if(pre==null || pre.length==0 ||in==null || in.length==0)
		return null;
	
	TreeNode root = new TreeNode(pre[0]);
	int leftTreeNum=0;
	for(int i=0;i<in.length;i++){
		if(in[i] == root.val){
			leftTreeNum = i;
			break;
		}
	}
	int rightTreeNum = in.length - leftTreeNum - 1;
	//left
	int [] root_left_pre = new int [leftTreeNum];
	for(int j=1;j<leftTreeNum+1;j++){
		root_left_pre[j-1] = pre[j];
	}
	int [] root_left_mid = new int [leftTreeNum];
	for(int j=0;j<leftTreeNum;j++){
		root_left_mid[j] = in[j];
	}
	TreeNode left =  reConstructBinaryTree(root_left_pre,root_left_mid);
	root.left = left;
//right
	int [] root_right_pre = new int [rightTreeNum];
	int index = 0;
	for(int j=leftTreeNum+1;j<pre.length;j++){
		root_right_pre[index] = pre[j];
		index++;
	}
	int [] root_right_mid = new int [rightTreeNum];
	index = 0;
	for(int j=leftTreeNum+1;j<in.length;j++){
		root_right_mid[index] = in[j];
		index++;
	}
	TreeNode right =  reConstructBinaryTree(root_right_pre,root_right_mid);
	root.right = right;
	return root;
	}

	public static void main(String[] args) {
		int[] pre_order=new int[]{1,2,3,4,5,6,7};
		int[] mid_order=new int[]{3,2,4,1,6,5,7};
		TreeNode root = new TreeRetriveDemo().reConstructBinaryTree(pre_order,mid_order);
		/*System.out.println(root.getValue());
		System.out.println(root.getLeft().getValue());
		System.out.println(root.getLeft().getLeft().getValue());
		System.out.println(root.getRight().getValue());
		System.out.println(root.getRight().getRight().getValue());*/
	}

	public static BinaryTree retriveTree(int[] pre_order, int[] mid_order){

		if(pre_order==null || mid_order==null || pre_order.length==0 || mid_order.length==0)
			return null;

		BinaryTree root = new BinaryTree(pre_order[0]);
		int leftTreeNum = 0;
		for(int i=0;i<mid_order.length;i++){
			if(mid_order[i]==root.getValue()){
				leftTreeNum = i;
				break;
			}
		}
		BinaryTree leftTreeNode = null;
		if(leftTreeNum>0){
			int[] left_pre_Tree = new int[leftTreeNum];
			int[] left_mid_Tree = new int[leftTreeNum];
			for(int j=0;j<leftTreeNum;j++){
				left_pre_Tree[j] = pre_order[j+1];
				left_mid_Tree[j] = mid_order[j];
			}
			leftTreeNode = retriveTree(left_pre_Tree,left_mid_Tree);
		}
		root.setLeft(leftTreeNode);
		BinaryTree rightTreeNode = null;
		int rightTreeNum = mid_order.length-leftTreeNum-1;
		if(rightTreeNum>0){
			int[] right_pre_Tree = new int[rightTreeNum];
			int[] right_mid_Tree = new int[rightTreeNum];
			for(int j=0;j<rightTreeNum;j++){
				right_pre_Tree[j] = pre_order[j+leftTreeNum+1];
				right_mid_Tree[j] = mid_order[j+leftTreeNum+1];
			}
			rightTreeNode = retriveTree(right_pre_Tree,right_mid_Tree);
		}
		root.setRight(rightTreeNode);

		return root;
	}

}
