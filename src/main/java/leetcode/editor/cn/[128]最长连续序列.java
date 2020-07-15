//给定一个未排序的整数数组，找出最长连续序列的长度。 
//
// 要求算法的时间复杂度为 O(n)。 
//
// 示例: 
//
// 输入: [100, 4, 200, 1, 3, 2]
//输出: 4
//解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。 
// Related Topics 并查集 数组

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

class LongestConsecutiveSequence{
      public static void main(String[] args) {
           Solution solution = new LongestConsecutiveSequence().new Solution();
      }
 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //100, 4, 200, 1, 3, 2
    //O(N)
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }
        int longest= 0;
        for (int num:num_set) {
            //例如遍历到4,如果4-1=3存在，则不需要遍历了，因为4开头肯定不是最长的，直接跳过
            if(!num_set.contains(num-1)){
              int cur=num;
              int curLength=1;
              while(num_set.contains(++cur)){
                  curLength++;
              }
                longest=Math.max(curLength,longest);
            }
        }
        return longest;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}