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
          List<List<Integer>> ans=solution.threeSum(new int[]{-1,0,1,2,-1,-4});
          System.out.println(ans);
      }
 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();

        //-4,-1,-1,0,1,2
        //0 -1 -1 1 2 4


       for(int i=0;i<nums.length-2;i++){
           //如果nums[i]大于0，则不需要再比较了
           if(nums[i]>0)continue;
           if(i!=0 && nums[i]==nums[i-1])continue;
           int target=0-nums[i];
           int lo=i+1;
           int hi=nums.length-1;
           while(lo<hi){
               if((nums[lo]+nums[hi])==target){

                   res.add(Arrays.asList(nums[i],nums[lo],nums[hi]));

                   //相同的情况， 则lo++, hi-- 直到遇到不相同的数
                   int tmp=nums[hi];
                   while(lo<hi && tmp==nums[--hi]);// 跳过相同的

                   tmp=nums[lo];
                   while(lo<hi && tmp==nums[++lo]);// 跳过相同的

               }else if((nums[lo]+nums[hi])<target){
                   lo++;
               }else{
                   hi--;
               }
           }
       }
        return res;
    }

    /*public void  dfs(List<List<Integer>> res,List<Integer> cur,int begin,int sum,int[] nums){
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
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}