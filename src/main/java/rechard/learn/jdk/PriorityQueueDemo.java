package rechard.learn.jdk;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

    public static void main(String[] args) {
        PriorityQueue queue=new PriorityQueue();

        queue.offer(1);
        queue.offer(3);
        queue.offer(10);
        queue.offer(2);
        queue.offer(5);
        while(!queue.isEmpty()) {
            System.out.println("元素："+queue.poll());
        }
    }
}
