package rechard.learn.algorithm.btree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeDFSDemo {

    public List dfs(TreeNode root){
        TreeNode node=root;
        List list=new ArrayList();
        Stack<TreeNode> s=new Stack();
        while(node!=null && !s.isEmpty()){
            if(node==null){
                node=s.peek().right;
                if(node==null){
                    list.add(s.pop());
                }
            }else {
                s.push(node);
                node = node.left;
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
