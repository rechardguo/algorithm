//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。 
//
// 示例 1: 
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
// 
//
// 示例 2: 
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
// 
// Related Topics 字符串 动态规划

package leetcode.editor.cn;

import java.util.Stack;

class LongestValidParentheses{
      public static void main(String[] args) {
           Solution solution = new LongestValidParentheses().new Solution();
      }
 //leetcode submit region begin(Prohibit modification and deletion)
 // dp[i] 代表 当i为) 有几个有效的括号
 // 状态转移
 // 如果碰到 第i为 ) 则 判断前面一位s[i-1]是否为(,如果是则 dp[i]=dp[i-1-1]+2
 // 如果碰到 第i为 )，但是前一位i-1是)，则需要 判断下dp[i-1]是否有值，如果有值的话，s[i-dp[i-1]-1]是否为(
  // 如果是 则 dp[i-dp[i-1]-1-1]+2
class Solution {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            //如果遇到)
            if (s.charAt(i) == ')') {
                // i-1 是(
                if (s.charAt(i - 1) == '(') {
                    //判断 i>=2 避免i-2越界,例如 ()
                    //比较好理解是
                    /*if(i-2>=0){
                        dp[i]=dp[i-i-1]+2;
                    }else{
                        dp[i]=2;
                    }*/
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}