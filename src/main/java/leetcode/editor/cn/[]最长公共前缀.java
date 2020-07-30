//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串

package leetcode.editor.cn;
class LongestCommonPrefix{
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String longestCommonPrefix(String[] strs) {
            if(strs.length == 0)
                return "";
            String ans = strs[0];
            for(int i =1;i<strs.length;i++) {
                int j=0;
                for(;j<ans.length() && j < strs[i].length();j++) {
                    if(ans.charAt(j) != strs[i].charAt(j))
                        break;
                }
                ans = ans.substring(0, j);
                if(ans.equals(""))
                    return ans;
            }
            return ans;

        }


        /**
         * 为什么会超时
         * 	Time Limit Exceeded
         * @param strs
         * @return
         */
        public String longestCommonPrefix_1(String[] strs) {
            int i = 0;
            while (true) {
                int ch = -1;
                for (String str : strs) {
                    if (str == null) return null;
                    if (i >= str.length()) {
                        return str.substring(0, i);
                    } else {
                        if (ch == -1)
                            ch = str.charAt(i);
                        if (ch != str.charAt(i))
                            return str.substring(0, i);
                    }
                }
                i++;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}