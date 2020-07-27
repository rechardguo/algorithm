//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
// Related Topics 树

package leetcode.editor.cn;

import rechard.learn.algorithm.btree.TreeNode;

import java.util.Stack;

import static leetcode.editor.cn.TreeNodeUtils.createTreeNode;

class LowestCommonAncestorOfABinaryTree{
      public static void main(String[] args) {
          Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
          Integer[] nodes=new Integer[]{5,4,3,2,1};
          TreeNode root=TreeNodeUtils.createTreeNode(nodes);
          TreeNode res=solution.lowestCommonAncestor(root,new TreeNode(4),new TreeNode(3));
          System.out.println(res);
         /* TreeNode root=new TreeNode(1);
          root.left=new TreeNode(2);
          root.right=new TreeNode(3);
          TreeNode res=solution.lowestCommonAncestor(root,new TreeNode(2),new TreeNode(3));
          System.out.println(res.val);*/
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
    /**
     * 该题应该是一道后序遍历的题目，
     * 所谓的后续遍历，就是说
     *
     * 找出以root.left作为根，找是否有公共节点
     * TreeNode left = lowestCommonAncestor(root.left, p, q);
     * 找出以root.right作为根，找是否有公共节点
     *  TreeNode right = lowestCommonAncestor(root.right, p, q);
     *
     * 都找出后就可以判断结果了
     *
     * 如果left==null ,说明left 没有共用节点， 题设已经告诉我们2个节点一定是有效存在的
     * 则肯定存在right
     *
     * 同理对于right
     *
     * 如果left ,right都有值的化，则根就是公用节点
     *
     * 套路
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == p || q == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //如果left为空，说明这两个节点在cur结点的右子树上，我们只需要返回右子树查找的结果即可
        if (left == null)
            return right;
        //同上
        if (right == null)
            return left;
        //如果left和right都不为空，说明这两个节点一个在cur的左子树上一个在cur的右子树上，
        //我们只需要返回cur结点即可。
        return root;
    }

    public TreeNode lowestCommonAncestor_my(TreeNode root, TreeNode p, TreeNode q) {

        Stack<TreeNode> stack1=helpStack(root,p);
        Stack<TreeNode> stack2=helpStack(root,q);
        if(stack1.size()>stack2.size()){
            for(int i=stack1.size()-stack2.size();i>=0;i--)
              stack1.pop();
        }

        if(stack2.size()>stack1.size()){
            for(int i=stack2.size()-stack1.size();i>=0;i--)
                stack2.pop();
        }

        while(stack1.peek().val!=stack2.peek().val){
            stack1.pop();
            stack2.pop();
        }
        return stack1.peek();
    }

    public Stack helpStack(TreeNode root,TreeNode target){
        Stack<TreeNode> stack=new Stack();
        TreeNode node=root;
        while(node!=null || !stack.isEmpty()){
            if(node==null){
                node=stack.peek().right;
                if(node==null) {
                    TreeNode tmp=stack.pop();
                    if(!stack.isEmpty()&&tmp.val==stack.peek().right.val)
                        stack.pop();
                    continue;
                }
            }
            stack.push(node);
            if(node.val==target.val) {
                break;
            }
            node=node.left;
        }
        return stack;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}