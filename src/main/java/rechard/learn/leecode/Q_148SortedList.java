package rechard.learn.leecode;


import rechard.learn.leecode.datastructure.ListNode;

public class Q_148SortedList {

    public static void main(String[] args) {
        int [] ns=new int[]{2,6,3,4,9,5};
        ListNode n=new ListNode(ns[0]);
        ListNode root=n;
        for (int i = 1; i <ns.length ; i++) {
            n.next=new ListNode(ns[i]);
            n=n.next;
        }
        ListNode result =sortList(root);
        System.out.println(result);
    }

    public static ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode fast=head , slow=head,prev=null;
        while(fast!=null&&fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        ListNode l1=sortList(head);
        ListNode l2=sortList(slow);
        return merge(l1,l2);
    }

    private static ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(0);
        ListNode p=dummy;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                p.next=l1;
                l1=l1.next;
            }else{
                p.next=l2;
                l2=l2.next;
            }
            p=p.next;
        }
        if(l1!=null){
            p.next=l1;
        }
        if(l2!=null){
            p.next=l2;
        }
        return dummy.next;
    }

    public static ListNode sortList_my(ListNode head) {
        if(head==null||head.next==null||head.next.next==null)
            return head;

        ListNode s=head;
        ListNode f=head.next;
        ListNode l1=s;
        ListNode l2=f;
        ListNode n=f.next;
        while(n!=null){
            s.next=n;
            f.next=n.next;
            n=n.next!=null?n.next.next:null;
            s=s.next;
            f=f.next;
            if(s!=null&&s.next!=null)s.next=null;
            if(f!=null&&f.next!=null)f.next=null;
        }

        l1=sortList(l1);
        l2=sortList(l2);

        return merge_my(l1,l2);
    }

    private static ListNode merge_my(ListNode l1,ListNode l2){
        ListNode root=null;
        ListNode lastNode=null;
        ListNode node=null;
        while(l1!=null||l2!=null){
            if(l1!=null&&l2==null){
                node=l1;
                l1=l1.next;
            }else if(l2!=null&&l1==null){
                node=l2;
                l2=l2.next;
            }else{
                if(l1.val>=l2.val){
                    node=l1;
                    l1=l1.next;
                }else{
                    node=l2;
                    l2=l2.next;
                }
            }

            if(root==null){
                root=node;
                lastNode=root;
            }else{
                lastNode.next=node;
                lastNode=node;
            }

        }
        return root;
    }

}
