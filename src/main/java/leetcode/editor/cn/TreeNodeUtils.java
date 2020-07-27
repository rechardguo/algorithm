package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;
import rechard.learn.algorithm.btree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * 用于构建出 从数组到treenode的工具
 */
public class TreeNodeUtils {


    @Test
    public void check(){
        Integer[] nodes=new Integer[]{3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root=createTreeNode(nodes);
        Integer[] res=toArrays(root);
        Assert.assertArrayEquals(nodes,res);
    }



    public static TreeNode createTreeNode(Integer[] nodes){
        int index=0;
        TreeNode root=new TreeNode(nodes[0]);
        help(nodes,0,root);
        return root;
    }

    public static void help(Integer[] nodes,int index,TreeNode parent){
        int leftChildIndex=2*index+1;
        int rightChildIndex=leftChildIndex+1;
        if(leftChildIndex<nodes.length) {
            parent.left = new TreeNode(nodes[leftChildIndex]);
            help(nodes,leftChildIndex,parent.left);
        }
        if(rightChildIndex<nodes.length) {
            parent.right = new TreeNode(nodes[rightChildIndex]);
            help(nodes,rightChildIndex,parent.right);
        }
    }

    public static Integer[] toArrays(TreeNode root){
        if(root==null)return null;
        List<Integer> list=new ArrayList<>();
        LinkedList<TreeNode> q=new LinkedList<>();
        q.addLast(root);
        while(!q.isEmpty()){
            int size=q.size();
            for (int i = 0; i <size ; i++) {
                TreeNode node =q.pop();
                if(node!=null) {
                    list.add(node.val);
                    q.addLast(node.left);
                    q.addLast(node.right);
                }
            }
        }
        Integer[] res=new Integer[list.size()];
        list.toArray(res);
        return res;
    }
}
