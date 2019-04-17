package rechard.learn.jzoffer.tree;

import rechard.learn.algorithm.btree.TreeNode;

import java.util.Stack;

public class TreeDepth {
    //dsf 深度优先
    public int sulution(TreeNode node){
       if(node==null)
           return 0;
       int left=sulution(node.left);
       int right=sulution(node.right);
       return (left>right)?left+1:right+1;

    }

}
