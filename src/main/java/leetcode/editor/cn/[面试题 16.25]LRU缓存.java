//设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存
//被填满时，它应该删除最近最少使用的项目。 
//
// 它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新
//的数据值留出空间。 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class LruCacheLcci{
      public static void main(String[] args) {

      }
 //leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    private int cap;
    private int count;
    private Map<Integer,Node> map;
    private Node head; //头代表最频繁的访问
    private Node tail; //尾代表最不频繁的访问
    class Node{
        int val;
        int key;
        public Node(final int val, final int key) {
            this.val = val;
            this.key = key;
        }
        Node next;
        Node pre;
    }

    public LRUCache(int cap) {
        if(cap<=0)
            throw new IllegalArgumentException("capacity of LRUCache should large than 0");
         this.cap = cap;
         this.map = new HashMap(cap);
    }

    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node node=map.get(key);
            // 访问该节点，将该节点放到头
            node.pre.next=node.next;
            node.next.pre=node.pre;

            node.next=head;
            head.pre=node;
            head=node;
            return node.val;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        Node node=map.get(key);
        if(node!=null){
            node.val=value;
        }else {
            if (count == cap) {
                //去掉tail，这里使用替换值的方式
                tail.key=key;
                tail.val=value;
                Node tmp=tail;
                tail.pre.next=null;
                tail=tail.pre;

                head.pre=tmp;
                tmp.pre=null;
                tmp.next=head;
                head=tmp;

            } else {
                node=new Node(key,value);
                if(head==null) {
                    head = node;
                    tail = head;
                }else {
                    node.next = head;
                    head.pre = node;
                    head = node;
                }
                count++;

            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}