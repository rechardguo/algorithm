//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索

package leetcode.editor.cn;

import rechard.learn.algorithm.btree.TreeNode;

import java.util.*;

class BinaryTreeLevelOrderTraversal{
      public static void main(String[] args) {
           Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
      }
 //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //return bfs(root);
        return dfs(root);
       /* List<List<Integer>> ans=new ArrayList<>();
        dfs_recrusive(root,1,ans);
        return ans;*/
    }

    /**
     * dfs采用递归方式
     * @param node
     * @param level
     * @param list
     */
    public void dfs_recrusive(TreeNode node,int level, List<List<Integer>> list){
        if(node==null)return ;
        while(list.size()<level){
            list.add(new ArrayList<Integer>());
        }
        list.get(level-1).add(node.val);
        dfs_recrusive(node.left,level+1,list);
        dfs_recrusive(node.right,level+1,list);
    }

    /**
     * dfs 非递归方式
     * @param node
     * @return
     */
    public List<List<Integer>> dfs(TreeNode node){
        List<List<Integer>> ans=new ArrayList<>();
        int level=1;
        Stack<TreeNode> stack=new Stack<>();
        while(node!=null || !stack.isEmpty()){

            if(node==null){
                node=stack.pop().right;
                level--;
                continue;
            }

            stack.add(node);

            if(ans.get(level-1)==null){
                ans.add(level-1,new ArrayList<Integer>());
            }
            ans.get(level-1).add(node.val);
            node=node.left;

            level++;
        }
        return ans;
    }

    public List<List<Integer>> bfs(TreeNode node){
        List<List<Integer>> ans=new ArrayList<>();
        if(node==null) return ans;
        Queue<TreeNode> queue=new LinkedList();
        queue.offer(node);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode n=queue.poll();
                list.add(n.val);
                if(n.left!=null)queue.offer(n.left);
                if(n.right!=null)queue.offer(n.right);
            }
            ans.add(list);
        }
       return ans;

    }

}
//leetcode submit region end(Prohibit modification and deletion)

}