//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划

package leetcode.editor.cn;
class MinimumPathSum{
      public static void main(String[] args) {
           Solution solution = new MinimumPathSum().new Solution();
      }
 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
     int min=Integer.MAX_VALUE;
     public int minPathSum(int[][] grid) {
         if(grid==null) return 0;
         int [][] dp=new int [grid.length][grid[0].length];
         minPathSum(grid,dp,0,0,0);
         return min;
     }

    public void minPathSum(int[][] grid, int [][] dp,int begin_i,int begin_j,int sum) {
        if(begin_i>grid.length-1 || begin_j>grid[0].length-1){
            return;
        }
        if(begin_i==grid.length-1 && begin_j==grid[0].length-1){
            min=Math.min(min,sum+grid[begin_i][begin_j]);
            return;
        }

        if(dp[begin_i][begin_j]==0){
            dp[begin_i][begin_j]=sum;
        }else if(sum<dp[begin_i][begin_j]){
            dp[begin_i][begin_j]=sum;
        }else if(sum>=dp[begin_i][begin_j]){
            return;
        }
        minPathSum(grid,dp,begin_i+1,begin_j,sum+grid[begin_i][begin_j]);//right
        minPathSum(grid,dp,begin_i,begin_j+1,sum+grid[begin_i][begin_j]);//down
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}