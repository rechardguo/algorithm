package rechard.learn.sgu.datastructure;

import java.util.Scanner;

//使用数组来建立一个队列
//单向队列
public class ArrayQueue {

    private int maxSize;
    private int front=0;
    private int tail=0;
    private int[] arr;

    public ArrayQueue(final int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }
    public boolean isFull(){
        return tail==maxSize;
    }
    public int size(){
        return tail-front;
    }
    public boolean isEmpty(){
        return size()==0;
    }
    public void add(int ele){
        if(isFull()){
            throw new RuntimeException("队列已满,不能放入");
        }
        this.arr[tail++]=ele;
    }
    public int get(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能取出");
        }
        return this.arr[front++];
    }
    public void display(){
        for(int i=front;i<tail;i++){
            System.out.printf("%d\t",arr[i]);
        }
    }
    public static void main(String[] args) {
        ArrayQueue queue=new ArrayQueue(3);
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
