//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表

package leetcode.editor.cn;

import rechard.learn.leecode.datastructure.ListNode;

class SwapNodesInPairs{
      public static void main(String[] args) {
           Solution solution = new SwapNodesInPairs().new Solution();
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
//dummy
//a->b->c
//pre cur next
//a->c->b
//pre  next cur
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode cur=pre.next;
        while(cur!=null && cur.next!=null){
            ListNode next=cur.next;
            pre.next=next;
            cur.next=next.next;
            next.next=cur;
            pre=cur;
            cur=cur.next;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}