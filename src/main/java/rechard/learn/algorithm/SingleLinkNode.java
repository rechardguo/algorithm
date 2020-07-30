package rechard.learn.algorithm;

/**
 * 单链表的节点
 */
public class SingleLinkNode implements Cloneable{
    public int val;
    public SingleLinkNode next;
    public SingleLinkNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
