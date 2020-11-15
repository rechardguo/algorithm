//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找

package leetcode.editor.cn;
class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof{
      public static void main(String[] args) {
          new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution().search(new int[]{5,7,7,8,8,10},6);
      }
 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
       if(nums==null || nums.length==0)return 0;
       int left=leftBinarySearch(nums,target);
       int right=rightBinarySearch(nums,target);
       if(left!=-1&&right!=-1)return right-left+1;
       if(left==-1&&right==-1)return 0;
       if(left==-1||right==-1)return 1;
       return 0;
    }

    public int leftBinarySearch(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid= left+(right-left>>1);
            if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                if(right==mid)break;
                right=mid;
            }
        }
        return nums[left]==target?left: nums[right]==target?right:-1;
    }

     public int rightBinarySearch(int[] nums,int target){
         int left=0;
         int right=nums.length-1;
         while(left<right){
             int mid= left+(right-left>>1);
             if(nums[mid]>target){
                 right=mid-1;
             }else if(nums[mid]<target){
                 left=mid+1;
             }else{
                 if(left==mid)break;
                 left=mid;
             }
         }
         return nums[right]==target?right: nums[left]==target?left:-1;
     }
}
//leetcode submit region end(Prohibit modification and deletion)

}