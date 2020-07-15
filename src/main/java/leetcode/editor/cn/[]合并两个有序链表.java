//将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表

package leetcode.editor.cn;

import rechard.learn.leecode.datastructure.ListNode;

class MergeTwoSortedLists{
      public static void main(String[] args) {
           Solution solution = new MergeTwoSortedLists().new Solution();
      }
 //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                cur.next=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        while(l1!=null){
            cur.next=l1;
            l1=l1.next;
            cur=cur.next;
        }

        while(l2!=null){
            cur.next=l2;
            l2=l2.next;
            cur=cur.next;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}