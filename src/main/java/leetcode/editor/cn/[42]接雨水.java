//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针

package leetcode.editor.cn;
class TrappingRainWater{
      public static void main(String[] args) {
          Solution solution = new TrappingRainWater().new Solution();
          int ans=solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
          System.out.println(ans);
      }
 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        if(height==null) return 0;
        int ans=0;
        for(int i=1;i<height.length-1;i++){
            int l_max=0;
            int r_max=0;
            for(int j=i;j>=0;j--){
                l_max=Math.max(l_max,height[j]);
            }

            for(int j=i;j<height.length;j++){
                r_max=Math.max(r_max,height[j]);
            }

            ans+=Math.min(l_max,r_max)-height[i];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}