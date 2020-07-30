package rechard.learn.algorithm.sort;

import rechard.learn.algorithm.SingleLinkNode;
import rechard.learn.leecode.datastructure.ListNode;

import java.util.LinkedList;
import java.util.Random;

public class SortUtil {
    //判断两个数组是否相等
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null))
            return false;
        if(arr1 == null && arr2 == null)
            return true;
        if(arr1.length != arr2.length)
            return false;
        for(int i = 0;i < arr1.length;i++) {
            if(arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

    public  static int[] generateArr(int i){
        int arr[] = new int[i];
        Random r = new Random();
        for(int j=0;j<i;j++)
            arr[j]= r.nextInt((j+1)*100);
        return arr;
    }

    public static void print(int[] arr){
        for (int i = 0; i <arr.length; i++) {
            System.out.print(arr[i]);
            if(i<arr.length-1)
            System.out.print(",");
        }
        System.out.println("");
    }

    /**
     * 用于复制一份int[]
     * @param arr
     * @return
     */
    public  static int[] clone(int[] arr){
        int[] dest=new int[arr.length];
        System.arraycopy(arr,0,dest,0,arr.length);
        return dest;
    }

    public static ListNode randomLinkSort(int length) {
        Random r = new Random();
        ListNode head = new ListNode(r.nextInt(100));
        ListNode node = head;
        for (int i = 0; i < length; i++) {
            node = node.next = new ListNode(r.nextInt(100));
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



    public  static SingleLinkNode clone(SingleLinkNode node) throws CloneNotSupportedException {
       if(node==null)return null;
        SingleLinkNode copyNode=(SingleLinkNode)node.clone();
        copyNode.next=clone(node.next);
        return copyNode;
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }

    public static LinkedList toLinkedList(ListNode node) {
        LinkedList<ListNode> linkedList=new LinkedList();
        while(node!=null){
            linkedList.add(node);
            node=node.next;
        }
        linkedList.sort((node1,node2)->{
            return node1.val-node2.val;
        });
        return linkedList;
    }
}
