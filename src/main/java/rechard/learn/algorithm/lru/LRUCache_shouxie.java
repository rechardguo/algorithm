package rechard.learn.algorithm.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU 手写实现
 */
public class LRUCache_shouxie {

    DoubleLinkedList doubleLinkedList;
    Map<Integer,Node> m;
    int cap;
    public LRUCache_shouxie(final int cap) {
        this.cap = cap;
        this.m= new HashMap<>();
        this.doubleLinkedList=new DoubleLinkedList();
    }


    public void put(int key,int val){
        Node node=new Node(key,val);
        if(m.get(key)!=null){
            doubleLinkedList.remove(m.get(key));
            m.remove(key);
        }

        if(doubleLinkedList.size()==cap){
            doubleLinkedList.removeLast();
            doubleLinkedList.addFirst(node);
        }else{
            doubleLinkedList.addFirst(node);
        }
        m.put(key,node);
    }

    public Node get(int key){
        if(!m.containsKey(key))
            return null;
        Node node=m.get(key);
        put(key,node.value);
        return node;
    }

    public String print() {
        return this.doubleLinkedList.print();
    }

    static class Node{
        Node pre,next;
        int key;
        int value;

        public Node(final int key, final int value) {
            this.key = key;
            this.value = value;
        }
    }
    static  class DoubleLinkedList{
        int size=0;
        Node head,tail;
        public void removeLast(){

            if(tail==head) {
                tail = head = null;
                size--;
                return;
            }
            if(tail!=null) {
                Node tailParent=tail.pre;
                tail.pre.next=null;
                tail.pre=null;
                tail=null;
                tail=tailParent;
                size--;
            }

        }
        public void addFirst(Node node){
                if(head==null){
                    head=node;
                    tail=head;
                }else{
                    node.next=head;
                    head.pre=node;
                    head=node;
                }
                size++;
        }
        public void remove(Node node){
            if(head==tail){//只有1个节点
                head=tail=null;
                size--;
            }
            if(node.pre==null){
                //node is head
                Node next=head.next;
                head.next.pre=null;
                head=null;
                head=next;
                size--;
                return;
            }
            if(node.next==null){
                //node is tail
                Node pre=tail.pre;
                tail.pre.next=null;
                tail=null;
                tail=pre;
                size--;
                return ;
            }

            node.pre.next=node.next;
            node.next.pre=node.pre;
            node=null;
            size--;
        }
        public int size(){
            return size;
        }

        public String print() {
            StringBuilder builder=new StringBuilder();
            Node node=head;
            while(node!=null){
                builder.append(node.value).append(",");
                node=node.next;
            }
            int lastCommaIndex=-1;
            if((lastCommaIndex=builder.lastIndexOf(","))!=-1) {
                builder.delete(lastCommaIndex,lastCommaIndex+1);
            }
            return builder.toString();
        }
    }
}
