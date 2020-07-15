//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索

package leetcode.editor.cn;

import rechard.learn.algorithm.btree.TreeNode;

class SymmetricTree{
      public static void main(String[] args) {
           Solution solution = new SymmetricTree().new Solution();
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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isSymmetric(root.left,root.right);
    }
    public boolean isSymmetric(TreeNode t1,TreeNode t2) {
        //比较当前节点是否对称
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        //当前节点对称，则比较left和 right
        return isSymmetric(t1.left,t2.right) && isSymmetric(t1.right,t2.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}