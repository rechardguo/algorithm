package rechard.learn.leecode;


import rechard.learn.leecode.datastructure.ListNode;

public class Q_83RemoveDuplicatesFromfortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode node=head;
        while(node!=null){
            if(node.next==null)
                break;
            if(node.val==node.next.val){
                node.next=node.next.next;
            }else{
                node=node.next;
            }
        }
        return head;
    }


    //虽然通过了，但是时间和空间复杂度都不高
    public ListNode deleteDuplicates_my(ListNode head) {
        if(head==null)return null;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode i=dummy.next;
        ListNode j=i.next;
        while(j!=null){
            if(i.val==j.val){
                while(j!=null&&j.val==i.val){
                    j=j.next;
                }
                i.next=j;
                i=j;
            }else{
                i=j;
                j=j.next;
            }
        }
        return dummy.next;
    }
}
