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
import java.util.List;
import java.util.Stack;

class BinaryTreeZigzagLevelOrderTraversal_2 {
      public static void main(String[] args) {
           Solution solution = new BinaryTreeZigzagLevelOrderTraversal_2().new Solution();
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(root==null) return res;
        Stack<TreeNode> s1= new Stack();
        Stack<TreeNode> s2= new Stack();
        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty()) {
            if(!s1.isEmpty()){
                List<Integer> l = new ArrayList();
                while(s1.isEmpty()){
                    TreeNode node=s1.pop();
                    l.add(node.val);
                    if(node.left!=null)
                        s2.push(node.left);
                    if(node.right!=null)
                        s2.push(node.right);
                }
                res.add(l);
            }

            if(!s2.isEmpty()){
                List<Integer> l = new ArrayList<Integer>();
                while(s2.isEmpty()){
                    TreeNode node=s2.pop();
                    l.add(node.val);
                    if(node.right!=null)
                        s1.push(node.right);
                    if(node.left!=null)
                        s1.push(node.left);
                }
                res.add(l);
            }

        }
        return  res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}