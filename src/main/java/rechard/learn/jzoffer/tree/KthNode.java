package rechard.learn.jzoffer.tree;

import java.util.Arrays;

public class KthNode {

	static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	
	/*TreeNode KthNode(TreeNode pRoot, int k){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = pRoot;
		if(node==null)
			return null;
		stack.push(node);
		int index = 0;
		while(node!=null || !stack.isEmpty()){
			if(node!=null){
				node = node.left;
			}else{
				node = stack.pop();
				node = node.right;
			}
			if(node!=null)
				stack.push(node);
		}
        
    }*/
	 public boolean VerifySquenceOfBST(int [] sequence) {
		    boolean flag = true;
	        if(sequence==null || sequence.length==0) return false;
	        if(sequence.length>2){
	            int mark=0;
	            boolean findMark=false;
	            for(int i=0;i<sequence.length-1;i++){
	            	if(findMark && sequence[i]<sequence[sequence.length-1])
	            		return false;
	                if(sequence[i]>sequence[sequence.length-1]){
	                    mark=i;
	                    findMark=true;
	                }
	            }
	            if(mark>0)
	             flag=flag?(flag&VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, mark))):false; 
	            if(mark<sequence.length-1)
	             flag=flag?(flag&VerifySquenceOfBST(Arrays.copyOfRange(sequence, mark, sequence.length-1))):false;
	        }else{//sequence.length=0 or 1 or 2
	            return true;
	        } 
	        return flag;
	    }
	 
	 
	 public static void main(String[]args){
		 int[] sequence =  new int[]{7,4,6,5};
		 System.out.println(new KthNode().VerifySquenceOfBST(sequence));
	 }

}
