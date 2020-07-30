//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表

package leetcode.editor.cn;

import rechard.learn.leecode.datastructure.ListNode;

import java.util.Stack;

class CongWeiDaoTouDaYinLianBiaoLcof{
      public static void main(String[] args) {
           Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
      }
 //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //:2 ms,击败了45.96% 的Java用户
    //o(2n)
    public int[] reversePrint(ListNode head) {
        Stack<Integer> s=new Stack<>();
        while(head!=null){
            s.push(head.val);
            head=head.next;
        }
        int[] res=new int[s.size()];
        int index=0;
        while(!s.isEmpty()){
            res[index++]=s.pop();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}