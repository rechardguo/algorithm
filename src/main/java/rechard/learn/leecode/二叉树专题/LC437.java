package rechard.learn.leecode.二叉树专题;

import rechard.learn.algorithm.btree.TreeNode;

public class LC437 {
    public int pathSum(TreeNode root, int sum){
        return pathSum0(root,0,sum);
    }
    public int pathSum0(TreeNode node,int cur,int sum) {
        if(node==null)return 0;
        int count=0;
        if(node.val+cur==sum){
            count+=1;
        }
        count+=pathSum0(node.left, node.val+cur,sum)+pathSum0(node.right, node.val+cur,sum);
        count+=pathSum0(node.left,0,sum);
        count+=pathSum0(node.right,0,sum);
        return count;
    }

    public static void main(String[] args) {
        LC437 s=new LC437();

    }
}
