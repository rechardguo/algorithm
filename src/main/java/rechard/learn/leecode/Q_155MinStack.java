package rechard.learn.leecode;

import java.util.Stack;

public class Q_155MinStack {
    Stack<Integer> s1=null;
    int min=Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public Q_155MinStack() {
        s1=new Stack();
    }

    public void push(int x) {
        if(x<=min){
            s1.push(min);
            min=x;
        }
        s1.push(x);
    }

    public void pop() {
        if(s1.pop()==min)
            min=s1.pop();
    }

    public int top() {
        return s1.peek();
    }


    public int getMin() {
        return min;
    }
}
