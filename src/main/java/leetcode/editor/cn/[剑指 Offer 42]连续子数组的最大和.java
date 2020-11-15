//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 分治算法 动态规划

package leetcode.editor.cn;

/**
 * dp[i] 代表是第i个位置最大的连续子数组的最大值
 * -2,1,-3,4,-1,2,1,-5,4
 * -2 1 -2 4  3 5 6 1 5
 *
 *
 */
class LianXuZiShuZuDeZuiDaHeLcof{
      public static void main(String[] args) {
           Solution solution = new LianXuZiShuZuDeZuiDaHeLcof().new Solution();
          System.out.println(solution.maxSubArray(new int[]{-1,-2}));
      }
 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int[] dp=new int[nums.length];
        dp[0]=max; //不要忘记了base case,通过base case 才能推导
        for(int i=1;i<nums.length;i++){
            if(dp[i-1]>0){
                //dp[i] 由dp[i-1]推出，如果dp[i-1]>0, 则dp[i]=dp[i-1]+nums[i] 肯定是包含该位置的最大值
                //不论nums[i] 是正数还是负数
                dp[i]=dp[i-1]+nums[i];
            }else{
                dp[i]=nums[i];
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}