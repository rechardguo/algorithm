package rechard.learn.sgu.datastructure;

import java.util.Scanner;

//循环队列
//ArrayQueue有个缺点就是不能循环
public class CycleQueue {
    private int maxSize;
    private int front=0;
    private int tail=0;
    private int[] arr;

    public CycleQueue(final int maxSize) {
        this.maxSize = maxSize+1;
        //空一个不用
        this.arr = new int[maxSize+1];
    }
    public boolean isFull(){
        //为什么不直接tail+1==front,因为tail=maxSize-1时候+1就越界
        return (tail+1)%maxSize==front;
    }
    public int size(){
        return (tail-front+maxSize)%maxSize;
    }
    public boolean isEmpty(){
        return size()==0;
    }
    public void add(int ele){
        if(isFull()){
            throw new RuntimeException("队列已满,不能放入");
        }
        this.arr[tail]=ele;
        tail=(tail+1)%maxSize;
    }
    public int get(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能取出");
        }
        int tmp=this.arr[front];
        front=(front+1)%maxSize;
        return tmp;
    }
    public void display(){
        for(int i=front;i<front+size();i++){
            System.out.printf("%d\t",arr[i%maxSize]);
        }
    }
    public int head(){
        return this.arr[front];
    }
    public static void main(String[] args) {
        CycleQueue queue=new CycleQueue(3);
        Scanner sc=new Scanner(System.in);
        char ch;
        boolean loop=true;
        while(loop){
            System.out.println("a:add a number");
            System.out.println("g:get a number");
            System.out.println("d:display queue");
            System.out.println("e:exit");
            ch=sc.next().charAt(0);
            try {
                if (ch == 'a') {
                    System.out.println("enter a number");
                    queue.add(sc.nextInt());
                    System.out.println("add success");
                } else if (ch == 'g') {
                    System.out.println("get head number: " + queue.get());
                } else if (ch == 'd') {
                    queue.display();
                } else if (ch == 'e') {
                    loop = false;
                }
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
        System.out.println("project exit");

    }



}
