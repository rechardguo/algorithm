//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class PascalsTriangleIi{
      public static void main(String[] args) {
           Solution solution = new PascalsTriangleIi().new Solution();
          System.out.println(solution.getRow(5));
      }
 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res=new ArrayList<Integer>();
       for(int i=0;i<=rowIndex;i++){
           if(i==0) res.add(1);
           else {
               int pre=1;
               int size=res.size();
               for (int j=1;j<size;j++) {
                 int cur=res.get(j);
                 //set 是替换
                 res.set(j,cur+pre);
                 pre=cur;
               }
               res.add(1);
           }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}