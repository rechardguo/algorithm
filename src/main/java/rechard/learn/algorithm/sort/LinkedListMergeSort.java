package rechard.learn.algorithm.sort;

import java.util.LinkedList;

/**
 * 链表的排序， olog(n)
 *
 * 采用归并排序
 *
 */
public class LinkedListMergeSort {

    public Node sort(Node node){
        if(node==null)
            return null;
        Node head=node;
        Node slow=head;
        Node fast=head.next;
        while(fast.next!=null){
            slow=head.next;
        }


        Node left=sort(head);
        Node right=sort(slow);
        return mergeSort(left,right);
    }

    public Node mergeSort(Node node1,Node node2){
        return null;
    }


    private static class Node<E> {
        E item;
        Node<E> next;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
}
