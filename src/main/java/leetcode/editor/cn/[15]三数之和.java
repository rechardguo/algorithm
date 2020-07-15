//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum{
      public static void main(String[] args) {
           Solution solution = new ThreeSum().new Solution();
      }
 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        dfs(res,new ArrayList(),0,0,nums);
        return res;
    }
//-4,-1,-1,0,1,2
    public void  dfs(List<List<Integer>> res,List<Integer> cur,int begin,int sum,int[] nums){
        if(cur.size()>3) return;
        if(sum==0 && cur.size()==3){
            res.add(cur);
        }
        for (int i = begin; i < nums.length; i++) {
            if(cur.size()==0 && i>0 && nums[i-1]==nums[i] )
                continue; //剪枝
            List<Integer> list=new ArrayList<>();
            list.addAll(cur);
            list.add(nums[i]);
            dfs(res,list,i+1,sum+nums[i],nums);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}