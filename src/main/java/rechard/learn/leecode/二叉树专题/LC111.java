package rechard.learn.leecode.二叉树专题;

import rechard.learn.algorithm.btree.TreeNode;

import java.util.LinkedList;

public class LC111 {
    static class Solution {
        public int minDepth(TreeNode root) {
            if(root==null) return 0;
            int level=1;
            LinkedList<TreeNode> q=new LinkedList();
            q.offer(root);
            while(!q.isEmpty()){
                int size=q.size();
                for(int i=0;i<q.size();i++){
                    TreeNode node=q.poll();
                    if(node.left==null && node.right==null)
                        return level;
                    if(node.left!=null)
                        q.offer(node.left);
                    if(node.right!=null)
                        q.offer(node.right);
                }
                level++;
            }
            return level;
        }
    }


}
