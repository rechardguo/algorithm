package rechard.learn.jzoffer.tree;

import rechard.learn.algorithm.btree.TreeNode;

public class TreeMirror {

    public TreeNode getTreeMirror(TreeNode root){
        if(root==null) return null;
        getTreeMirror(root);
        getTreeMirror(root.left);
        getTreeMirror(root.right);
        return root;
    }

    private void changeChild(TreeNode n){
        TreeNode tmp=n.right;
        n.right=n.left;
        n.left=tmp;
    }

}
