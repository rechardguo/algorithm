//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组

package leetcode.editor.cn;
class ShunShiZhenDaYinJuZhenLcof{
      public static void main(String[] args) {
           Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
      }
 //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 输入：matrix =
     * [[1,2,3],
     *  [4,5,6],
     *  [7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     */

class Solution {
     public int[] spiralOrder(int[][] matrix) {
         int cols = matrix.length==0? 0 : matrix[0].length, rows = matrix.length, total = cols * rows;
         int[] result = new int[total];
         int x = 0, y = 0, xd=1, yd=0; // 坐标以及坐标增量 用-1，0，1控制分别控制水平和竖直方向移动
         int step = cols; // 直线移动的步长

         for( int i=0; i < total; i++ ){
             result[i] = matrix[y][x];
             if( --step == 0 ){ // 直线移动完成后，设置下一段移动 xd,yd,step值
                 int tmp = xd; xd = yd; yd = tmp; // 交换xd，yd值
                 if(xd != 0) {
                     step = --cols; // 设置下一段直线移动步长
                     xd = -xd; // 切换正负方向
                 }else{
                     step = --rows; // 设置下一段直线移动步长
                 }
             }
             // 坐标移动
             x = x + xd;
             y = y + yd;
         }

         return result;

     }
}
//leetcode submit region end(Prohibit modification and deletion)

}