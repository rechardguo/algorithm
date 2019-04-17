package rechard.learn.jzoffer.tree;

import rechard.learn.algorithm.btree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeBranchSum {

    public List<List<TreeNode>> findBranch(TreeNode node,int target){
        List<List<TreeNode>> container=new ArrayList<>();
        findBranch0(container,new ArrayList<>(),0,node,target);
        return container;
    }


    public void findBranch0(List<List<TreeNode>> container,List<TreeNode> parentList,int sum,TreeNode node,int target){
        if(node==null)return;
        if(node.left==null&&node.right==null){
            //leaf node
            if(sum+node.val==target){
                parentList.add(node);
                container.add(parentList);
            }
        }else if(node.left!=null){
            List<TreeNode> l=new ArrayList<>();
            l.addAll(parentList);
            findBranch0(container,l,sum+node.val,node.left,target);
        }else if(node.right!=null){
            List<TreeNode> l=new ArrayList<>();
            l.addAll(parentList);
            findBranch0(container,l,sum+node.val,node.right,target);
        }

    }

}
