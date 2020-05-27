//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层次遍历如下： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索

package leetcode.editor.cn;

import rechard.learn.algorithm.btree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class BinaryTreeZigzagLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
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
   //双端队列的运用 bfs
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res=new ArrayList<>();
            if(root==null) return res;
            LinkedList<TreeNode> dq=new LinkedList();//双端队列
            dq.add(root);
            boolean right2Left=false;
            while(!dq.isEmpty()) {
                int size=dq.size();
                List<Integer> li = new ArrayList<>();
                if(right2Left){
                    for(int i=0;i<size;i++){
                        TreeNode node=dq.pollLast();
                        li.add(node.val);
                        if(node.right!=null)
                            dq.addFirst(node.right);
                        if(node.left!=null)
                            dq.addFirst(node.left);
                    }
                }else{
                    for(int i=0;i<size;i++){
                        TreeNode node=dq.poll();
                        li.add(node.val);
                        if(node.left!=null)
                            dq.addLast(node.left);
                        if(node.right!=null)
                            dq.addLast(node.right);
                    }
                }
                right2Left=!right2Left;
                res.add(li);
            }
            return  res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}