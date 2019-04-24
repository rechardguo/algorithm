package rechard.learn.leecode;

import rechard.learn.algorithm.datastructure.ListNode;

import java.io.IOException;

/**
 * 2数之和
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807
 */

public class AddTwoNumbers {

    //网上的正确解法
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    //对照上面的正确解法
    public ListNode addTwoNumbers_my(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode tmp=dummy;
        int carry=0;
        while(l1!=null||l2!=null){
            int x=l1!=null?l1.val:0;
            int y=l2!=null?l2.val:0;
            int sum=carry+x+y;
            tmp.next=new ListNode(sum%10);//得到个位数
            carry=sum/10; // 得到十位数
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
            tmp=tmp.next;
        }
         //上次加后的数>0
        //例如5,2,5 和9,2,9 的情况，最后还进位补1，carry只可能是1
        if(carry==1)
            tmp.next=new ListNode(1);

        return dummy.next;
    }

    //错误解法3
    public ListNode addTwoNumbers_error3(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode tmp=dummy;
        int val=0;
        while(l1!=null||l2!=null){
            int x=l1!=null?l1.val:0;
            int y=l2!=null?l2.val:0;
            val=tmp.val+x+y;
            if(val<9){
                tmp.val=val;
                tmp.next=new ListNode(0);
            }else{
                tmp.val=val-10;
                tmp.next=new ListNode(1);
            }
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
            tmp=tmp.next;
        }


        return dummy.next;
    }

    //错误解法2
    public ListNode addTwoNumbers_error2(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode tmp=dummy;
        while(l1!=null||l2!=null){
            if(tmp==null) tmp=new ListNode(0);
            int x=l1!=null?l1.val:0;
            int y=l2!=null?l2.val:0;
            int val=tmp.val+x+y;
            if(val<9){
                tmp.val=val;
            }else{
                tmp.val=val-10;
                tmp.next=new ListNode(1);
            }
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
            tmp=tmp.next;
        }

        return dummy.next;
    }

    //错误解法1
    public ListNode addTwoNumbers_error(ListNode l1, ListNode l2) {
        ListNode tmp=new ListNode(0);
        ListNode root=new ListNode(0);
        root.next=tmp;
        ListNode next=null;
        while(l1!=null&&l2!=null){
            if(tmp==null) tmp=new ListNode(0);
            int val=tmp.val+l1.val+l2.val;
            if(val<9){
                tmp.val=val;
            }else{
                tmp.val=val-10;
                tmp.next=new ListNode(1);
            }
            l1=l1.next;
            l2=l2.next;
            tmp=tmp.next;
        }
        ListNode leftNode= l1==null?(l2==null?null:l2):l1;

        while(leftNode!=null){
            if(tmp==null) tmp=new ListNode(0);
            int val=tmp.val+leftNode.val;

            if(val<9){
                tmp.val=val;
            }else{
                tmp.val=val-10;
                tmp.next=new ListNode(1);
            }
            tmp=tmp.next;
            leftNode=leftNode.next;
        }

        return root.next;
    }



    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {

            ListNode l1 = stringToListNode(",2,");
            ListNode l2 = stringToListNode(",5,6,4,");

            ListNode ret = new AddTwoNumbers().addTwoNumbers_my(l1, l2);

            String out = listNodeToString(ret);

            System.out.print(out);
    }
}
