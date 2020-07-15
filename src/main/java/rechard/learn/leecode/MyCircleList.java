package rechard.learn.leecode;

class MyCircularQueue {

    private int head=0,tail=0,size=0;
    private int[] queue=null;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.queue=new int[k];
        for(int i=0;i<queue.length;i++)
            this.queue[i]=-1;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(!isFull()){
            this.queue[tail]=value;
            if(++tail==queue.length)
                tail=0;
            size++;
            return true;
        }
        return false;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(!isEmpty()){
            this.queue[head]=-1;
            if(++head==queue.length)
                head=0;
            size--;
            return true;
        }
        return false;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty())
            return -1;
        return queue[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty())
            return -1;
        return queue[tail-1==-1?queue.length-1:tail-1];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size==0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size!=0&&size==queue.length;
    }

    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(3);
        System.out.println(obj.enQueue(1));
        System.out.println(obj.enQueue(2));
        System.out.println(obj.enQueue(3));
        /*System.out.println(obj.enQueue(4));
        System.out.println(obj.deQueue());
        System.out.println(obj.deQueue());
        System.out.println(obj.Front());
        System.out.println(obj.Rear());
        System.out.println(obj.isEmpty());
        System.out.println(obj.isFull());*/
        System.out.println(obj.deQueue());
        System.out.println(obj.deQueue());
        System.out.println(obj.deQueue());
        System.out.println(obj.enQueue(4));
        System.out.println(obj.Rear());
    }
}