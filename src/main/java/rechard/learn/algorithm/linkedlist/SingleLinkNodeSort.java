package rechard.learn.algorithm.linkedlist;

import org.junit.Assert;
import org.junit.Test;
import rechard.learn.algorithm.sort.SortUtil;
import rechard.learn.leecode.datastructure.ListNode;

import java.util.LinkedList;

/**
 * 单链表的排序
 *
 * 归并排序时间复杂度
 * O(nlog2n)
 *
 *
 * 归并排序 是O(n)
 * // 1      3     5    2    4
 * // head         slow
 *
 * o(n) + 2*o(n/2) + 4*o(n/4)
 *
 * o(n*log2n)
 *
 */
public class SingleLinkNodeSort {


    @Test
    public void check(){
        for(int i=0;i<100;i++) {
            ListNode node = SortUtil.randomLinkSort(i);
            LinkedList<ListNode> l = SortUtil.toLinkedList(node);
            node = sortList(node);
            int index = 0;
            while (node != null) {
                Assert.assertEquals(node.val, l.get(index).val);
                index++;
                node = node.next;
            }
        }
    }


    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return merge(sortList(head), sortList(slow));
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        if(l2==null)return l1;
        if(l1.val>l2.val){
            l2.next=merge(l1,l2.next);
            return l2;
        }else{
            l1.next=merge(l1.next,l2);
            return l1;
        }
    }

   /* public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        return dummy.next;
    }
*/
}
