package rechard.learn.leecode;


import rechard.learn.leecode.datastructure.ListNode;

public class Q_21MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tmp=null;
        ListNode root=new ListNode(0);
        ListNode dummy=new ListNode(0);
        dummy.next=root;
        while(l1!=null||l2!=null){
            if(l1!=null&&l2!=null){
                if(l1.val<l2.val){
                    tmp=l1;
                    l1=l1.next;
                }else{
                    tmp=l2;
                    l2=l2.next;
                }
            }else if(l1!=null){
                tmp=l1;
                l1=l1.next;
            }else{
                tmp=l2;
                l2=l2.next;
            }
            root.next=tmp;
            root=root.next;
        }
        return dummy.next.next;
    }
}
