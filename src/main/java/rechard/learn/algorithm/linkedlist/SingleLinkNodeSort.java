package rechard.learn.algorithm.linkedlist;

import rechard.learn.algorithm.SingleLinkNode;

import java.util.Random;

/**
 * 单链表的排序
 */
public class SingleLinkNodeSort {
    public static SingleLinkNode randomLinkSort() {
        Random r = new Random();
        SingleLinkNode head = new SingleLinkNode(r.nextInt(100));
        SingleLinkNode node = head;
        for (int i = 0; i < 5; i++) {
            node = node.next = new SingleLinkNode(r.nextInt(100));
        }
        return head;
    }

    public static void print(SingleLinkNode h) {
        SingleLinkNode n = h;
        while (n != null) {
            System.out.print(n.val + ",");
            n = n.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        SingleLinkNode n = randomLinkSort();
        print(n);
        /*System.out.println("==========================");
        SingleLinkNode sortedNode = insertSort(n);
        print(sortedNode);*/
        System.out.println("==========================");
        SingleLinkNode sortedNode = quickSort(n);
        print(sortedNode);
    }

    public static SingleLinkNode quickSort(SingleLinkNode node) {
        SingleLinkNode tmp=node;
        while(tmp!=null&&tmp.next!=null){
            tmp=tmp.next;
        }
        return quickSort_0(node,tmp);
    }
    private static SingleLinkNode quickSort_0(SingleLinkNode head,SingleLinkNode tail) {
        System.out.println("---------------------------------");
        if(head==null||tail==null||head==tail)
           return null;
        int midVal=head.val;
        //辅助节点
        SingleLinkNode begin=new SingleLinkNode(-1);
        begin.next=head;
        SingleLinkNode midNode=head;
        SingleLinkNode node=head.next;
        SingleLinkNode preNode=node;
        while(node!=null){
            if(node.val<midNode.val){
                //断开node节点
                    preNode.next = node.next;
                    //放入midNode的左边
                    node.next = begin.next;
                    begin.next = node;
                    node = preNode.next;
            }else {
                preNode = node;
                node = node.next;
            }
            print(begin);
        }
        quickSort_0(begin.next,midNode);
        if(midNode!=null)
           quickSort_0(midNode.next,tail);
       return begin.next;
    }

    //单链表的插入排序
    public static SingleLinkNode insertSort(SingleLinkNode head) {
        SingleLinkNode newLinkHead = head;
        SingleLinkNode prev = head;
        SingleLinkNode cur = prev.next;
        while (cur != null) {
            if (cur.val >= prev.val) {
                prev = cur;
                cur = cur.next;
            } else {
                SingleLinkNode node = newLinkHead;
                SingleLinkNode preNode = null;
                while (node.val < cur.val) {
                    preNode = node;
                    node = node.next;
                    prev.next = cur.next;
                    //将cur插入到preNode和node之间
                    cur.next = node;
                    if (preNode != null)
                        preNode.next = cur;
                    if (node.val == newLinkHead.val)
                        newLinkHead = cur;
                    cur = prev.next;
                }
            }
        }
        return newLinkHead;
    }
}
