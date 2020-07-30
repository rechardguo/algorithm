//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6 
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
// 
//
// 示例 2: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉搜索树中。 
// 
// Related Topics 树

package leetcode.editor.cn;

import rechard.learn.algorithm.btree.TreeNode;

class LowestCommonAncestorOfABinarySearchTree{
      public static void main(String[] args) {
           Solution solution = new LowestCommonAncestorOfABinarySearchTree().new Solution();
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
    /**
     * 二叉搜索树 区别于二叉树就是二叉搜索树符合父节点大于左树的所有节点的值，小于右树的所有节点的值
     *
     *
     * 235 题就是前序遍历
     * 一拿到就比较看下是否p,q都是root的一侧
     * 如果不是，就是分别是左右两侧，否则p,q中1者和自己相等，这种情况就直接return 根节点即可。
     *
     * 236 题是后序遍历 不能用这个思路，以为步是二叉搜索树
     *
     * 在深度优先的基础上再来判断，也就是说
     *
     */
    class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||p==null||q==null)return null;

        if(p.val>root.val && q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}