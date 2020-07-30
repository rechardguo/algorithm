//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
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
    //https://www.bilibili.com/video/BV1Js411E7Bf/?spm_id_from=333.788.videocard.8

    /**
     * 解法精妙
     * [1 3 5] [2 4]
     * 1+ mergeTwoLists([3,5],[2,4])
     * [1 2 3 4 5]
     *
     * [3 5] [2 4]
     * 2 + mergeTwoLists([3,5],[2])
     *
     *
     *
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        if(l2==null)return l1;
        if(l1.val<l2.val){
            l1.next= mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}