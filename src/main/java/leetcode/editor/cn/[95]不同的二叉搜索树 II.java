//给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。 
//
// 示例: 
//
// 输入: 3
//输出:
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释:
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
// Related Topics 树 动态规划

package leetcode.editor.cn;

import rechard.learn.algorithm.btree.TreeNode;

import java.util.ArrayList;
import java.util.List;

class UniqueBinarySearchTreesIi{
      public static void main(String[] args) {
           Solution solution = (Solution) new UniqueBinarySearchTreesIi().new Solution();
          System.out.println(solution.generateTrees(3 ).size());
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
    public List<TreeNode> generateTrees(int n) {
        if(n<=0) return null;
        //动态规划
        List<TreeNode> list= new ArrayList();
        list.add(new TreeNode(1));
        for(int i=2;i<=n;i++){
            List<TreeNode> tmp=new ArrayList();
            for(TreeNode tn:list){
                // 新的节点作为root，由于新的节点一定大于dp[i-1]里所有的节点，所以这里直接加到root节点的左边
                TreeNode node=new TreeNode(i);
                node.left=cloneTreeNode(tn);
                tmp.add(node);
                //第二种请况，新的节点加入树中
                generateTrees0(i,tn,tn,tmp);
            }
            list=tmp;
        }
        return list;
    }

    private TreeNode cloneTreeNode(TreeNode node){
        if(node==null)return null;
        TreeNode cl=new TreeNode(node.val);
        cloneTreeNode(node.left);
        cloneTreeNode(node.right);
        return cl;
    }
    public void generateTrees0(int n,TreeNode root,TreeNode cur,List<TreeNode> list) {
        if(cur.left!=null){
            cur.left=new TreeNode(cur.left.val);
            generateTrees0(n,root,cur.left,list);
        }
        if(cur.right!=null){
            cur.right=new TreeNode(cur.right.val);
            generateTrees0(n,root,cur.right,list);
        }
        //新加的节点只可能加入到树中的右边
        if(cur.right==null){
            cur=new TreeNode(cur.val);
            cur.right=new TreeNode(n);
            list.add(root);
        }

    }


}
//leetcode submit region end(Prohibit modification and deletion)



//以下的解法会出现内存不足的exception
   /* class Solution {
        public List<TreeNode> generateTrees(int n) {
            if(n<=0) return null;
            //动态规划
            List<TreeNode>[] dp =new ArrayList[n+1];// 状态为数字 1，2，3...n
            dp[1]= new ArrayList();
            dp[1].add(new TreeNode(1));
            for(int i=2;i<=n;i++){
                dp[i]=new ArrayList();
                for(TreeNode tn:dp[i-1]){
                    // 新的节点作为root，由于新的节点一定大于dp[i-1]里所有的节点，所以这里直接加到root节点的左边
                    TreeNode node=new TreeNode(i);
                    node.left=tn;
                    dp[i].add(node);
                    //第二种请况，新的节点加入树中
                    List<TreeNode> all=new ArrayList<>();
                    generateTrees0(i,tn,tn,all);
                    dp[i].addAll(all);
                }
            }
            return dp[n];
        }
        public void generateTrees0(int n,TreeNode root,TreeNode cur,List<TreeNode> list) {
            if(cur.left!=null){
                generateTrees0(n,root,cur.left,list);
            }
            if(cur.right!=null){
                generateTrees0(n,root,cur.right,list);
            }
            //新加的节点只可能加入到树中的右边
            if(cur.right==null){
                cur.right=new TreeNode(n);
                list.add(root);
            }

        }


    }*/

}