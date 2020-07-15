package rechard.learn.leecode;


import rechard.learn.leecode.datastructure.ListNode;

public class Q_82RemoveDuplicatesfromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return null;
        ListNode dummy=new ListNode(head.val-1);
        dummy.next=head;
        ListNode p=dummy;
        ListNode c=p.next;
        while(c!=null){
            if(c.next==null){
                break;
            }
            if(c.next.val==c.val){
                ListNode tmp=c.next;
                while(tmp!=null&&tmp.val==c.val){
                    tmp=tmp.next;
                }
                p.next=tmp;
                c=tmp;
            }else{
                p=c;
                c=c.next;
            }
        }
        return dummy.next;
    }
}
