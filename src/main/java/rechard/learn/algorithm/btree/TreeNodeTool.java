package rechard.learn.algorithm.btree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
     10
   5    30
 3  null   20  60

 int []arr = new int[]{10, 5 ,30, 3,null, 20, 60};

 arr[i]
 arr[i].left=2*i+1;
 arr[i].right=2*i+2;
 */
public class TreeNodeTool {

    public static void inner(TreeNode root,List<TreeNode> l){
        TreeNode node = root;
        int beginIndex =l.size()==0?0:l.size()-1;
        l.add(node);
        if(node!=null) {
            l.add(node.left);
            l.add(node.right);
            if(node.left==null&&node.right==null)
                return;
        }
        for(int i=beginIndex;i<l.size();i++){
            node=l.get(i);
            inner(node,l);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(10);
        treeNode1.left = new TreeNode(5);
        treeNode1.left.left  = new TreeNode(3);
        treeNode1.right = new TreeNode(30);
        treeNode1.right.left = new TreeNode(20);
        treeNode1.right.right = new TreeNode(60);
        List<TreeNode> list = new ArrayList();
        inner(treeNode1,list);
        for (TreeNode node:list) {
            System.out.println(node);
        }

    }

/*
	public List Tree2Arr(TreeNode root){
       List l = new ArrayList();
       TreeNode node = root;
       Stack stack = new Stack();
       Stack stack2 = new Stack();
       stack.add(node);
       if(!stack.isEmpty()){
           if(node.left!=null)
               stack.push(node.left);
           if(node.right!=null)
               stack.push(node.right);

       }
       l.add(node);
        return l;
    }*/

    /*TreeNode Deserialize(String str) {
        if(str.length() == 0)
            return null;
        String[] strs = str.split(",");
        return Deserialize2(strs);
    }  
	 int index = -1;
    TreeNode Deserialize2(String[] strs) {
        index++;
        if(!strs[index].equals("#")) {
            TreeNode root = new TreeNode(0);     
            root.val = Integer.parseInt(strs[index]);
            root.left = Deserialize2(strs);
            root.right = Deserialize2(strs);
            return root;
        }
        return null;
    }*/
}
