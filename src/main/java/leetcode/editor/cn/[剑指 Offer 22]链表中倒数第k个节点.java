//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，
//它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。 
//
// 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
// Related Topics 链表 双指针

package leetcode.editor.cn;

import rechard.learn.leecode.datastructure.ListNode;

class LianBiaoZhongDaoShuDiKgeJieDianLcof{
      public static void main(String[] args) {
           Solution solution = new LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
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
    // 1-2-3-4-5 k=1
    // s f
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast=head;
        int count=0;
        while(fast!=null && count<k){
            fast=fast.next;
            count++;
        }
        if(fast==null){
            //node count <k
            return head;
        }
        ListNode slow=head;
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}