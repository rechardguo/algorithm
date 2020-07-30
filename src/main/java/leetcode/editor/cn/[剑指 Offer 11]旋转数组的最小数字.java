//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2
//] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
//
// 示例 1： 
//
// 输入：[3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 输入：[2,2,2,0,1]
//输出：0
// 
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sor
//ted-array-ii/ 
// Related Topics 二分查找

package leetcode.editor.cn;

import java.util.EnumSet;

class XuanZhuanShuZuDeZuiXiaoShuZiLcof{
      public static void main(String[] args) {
           Solution solution = new XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();
      }
 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
     // 3 4  5 1 2
     // 2 2 2 0 1

     public int minArray(int[] numbers) {
        int left=0;
        int right=numbers.length-1;
        while(left<right){
            int mid=left+(right-left>>1);
            if(numbers[mid]>numbers[right]){
                left=mid+1;
            }else if(numbers[mid]<numbers[right]){
                right=mid;
            }else{
                right--;
            }
        }
        return numbers[left];
     }
    public int minArray_my(int[] numbers) {
            if(numbers==null || numbers.length==0) return -1;// or throw exception
            int s=0,e=numbers.length-1;
            while(s<e){
                int m=s+(e-s>>1); // s+(e-s)/2
                if(numbers[m]>=numbers[s] ){ // left part in order
                    s=m;
                }else{ //right part in order
                    e=m;
                }
                if(Math.abs(s-e)==1)
                    break;
            }
            return numbers[s]<numbers[e]?numbers[s]:numbers[e];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}