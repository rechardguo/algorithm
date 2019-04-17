package rechard.learn.jzoffer.tree;

import rechard.learn.algorithm.btree.TreeNode;

public class IsA_TreeSubOfB_Tree {

    public  boolean isSubTree(TreeNode n1,TreeNode n2){

        if(n1==null&&n2==null)return false;

        boolean c1 = isTwoNodesEq(n1,n2) ;
        boolean c2 = isTwoNodesEq(n1.left,n2.left);
        boolean c3 = isTwoNodesEq(n1.right,n2.right);
        boolean c = c1&&c2&&c3;
        return (c&&n1!=null&&n2!=null) ? (c && isSubTree(n1.left,n2.left)&&isSubTree(n1.right,n2.right)):c;
    }

    private boolean isTwoNodesEq(TreeNode n1,TreeNode n2){
        return  n2==null&&n1!=null|| n1==null&&n2==null ||(n1!=null && n2!=null && (n1.val==n2.val));
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(10);
        treeNode1.left = new TreeNode(5);
        treeNode1.left.left  = new TreeNode(3);
        treeNode1.right = new TreeNode(30);
        treeNode1.right.left = new TreeNode(20);
        treeNode1.right.right = new TreeNode(60);

        TreeNode treeNode2 = new TreeNode(5);
        treeNode2.left = new TreeNode(3);
        System.out.println(new IsA_TreeSubOfB_Tree().isSubTree(treeNode1,treeNode2));

        treeNode2 = new TreeNode(5);
        treeNode2.left = new TreeNode(3);
        treeNode2.right =  new TreeNode(20);
        System.out.println(new IsA_TreeSubOfB_Tree().isSubTree(treeNode1,treeNode2));
    }
}
