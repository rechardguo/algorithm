package rechard.learn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JointNode {

    public static class Node{
        int value;
        public Node(int value) {
            this.value = value;
        }
        Node next;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        Node head2 = new Node(2);
        Node node = findJointNode(head1,head2);
        System.out.println(node);
    }

    private static Node findJointNode(Node head1, Node head2) {
        Node cur1 = head1;
        int node1Length = 0;
        Node cur2 = head2;
        int node2Length = 0;
        boolean chain1HasLoop = isChainHasLoop(cur1);
        boolean chain2HasLoop = isChainHasLoop(cur2);
        if (chain1HasLoop && chain2HasLoop) {
            while (cur1.next != null)
                cur1 = cur1.next;
            while (cur2.next != null)
                cur2 = cur2.next;
            //没有相交点
            if (cur1 != cur2) {


                return null;
            } else {//有相交点，但单链表没有环
                return getNodeWhenEndNodeSame(head1, head2, node1Length, node2Length);
            }

        } else if (!chain1HasLoop && !chain1HasLoop) {
            while (cur1.next != null)
                cur1 = cur1.next;
            while (cur2.next != null)
                cur2 = cur2.next;
            //没有相交点
            if (cur1 != cur2) {
                return null;
            } else {//有相交点，但单链表没有环
                return getNodeWhenEndNodeSame(head1, head2, node1Length, node2Length);
            }
        }else{
            return null;
        }
    }

    private static Node getNodeWhenEndNodeSame(Node head1, Node head2, int node1Length, int node2Length) {
        Node cur1;
        Node cur2;
        int startIndex = Math.abs(node2Length - node1Length);
        cur1 = head1;
        cur2 = head2;
        Node node = cur1;
        if (node2Length > node1Length)
            node = cur2;
        int tmp = 0;
        while (tmp < startIndex)
            node = node.next;
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    private static boolean isChainHasLoop(Node node){
        Set set = new HashSet();
        do {
            if(!set.contains(node))
                set.add(node);
            else
                return true;
            node=node.next;
        }while(node!=null);
        return false;
    }

}
