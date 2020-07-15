//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class PascalsTriangle{
      public static void main(String[] args) {
           Solution solution = new PascalsTriangle().new Solution();
      }
   //leetcode submit region begin(Prohibit modification and deletion)
   // 1 1
   //2
    class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(numRows==0) return res;
        List<Integer> basic=new ArrayList<Integer>();
        basic.add(1);
        res.add(basic);
        for(int i=1;i<numRows;i++){
            basic=new ArrayList<Integer>();
            basic.add(1);
            List<Integer> last=res.get(i-1);
            for(int j=1;j<last.size();j++){
                basic.add(last.get(j)+last.get(j-1));
            }
            basic.add(1);
            res.add(basic);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}