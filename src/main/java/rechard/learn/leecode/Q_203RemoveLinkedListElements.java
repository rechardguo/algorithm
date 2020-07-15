package rechard.learn.leecode;


import rechard.learn.leecode.datastructure.ListNode;

/**
 * 移除链表里的某个节点，对比Q_27
 *
 * 单链表的通性就是需要一个dummy节点
 * dummy.next指向给定的head节点
 *
 * return的时候return dummy.next
 *
 */
public class Q_203RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy=new ListNode(val==0?-1:-val);
        dummy.next=head;
        ListNode p =dummy,c=head;
        while(c!=null){
            if(c.val==val){
                p.next=c.next;
                c.next=null;
                c=p;
            }
            p=c;
            c=c.next;
        }
        return dummy.next;

    }
}
