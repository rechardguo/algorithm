package rechard.learn.algorithm.queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 啊哈算法-队列使用
 */
public class QQNumber {


    public static void main(String[] args) {
        String  qq="123456";
        int[] disorderqq=getDisOrderQQ(qq);
        System.out.println("原号码："+qq);
        System.out.println("==========打乱之后的号码============");
        for (int i = 0; i <disorderqq.length ; i++) {
            System.out.print(disorderqq[i]);
        }
        System.out.println("");
        System.out.println("==========还原号码============");
        int[] revertqq=revertDisOrderQQ(disorderqq);
        for (int i = 0; i <revertqq.length ; i++) {
            System.out.print(revertqq[i]);
        }
    }

    private static int[] revertDisOrderQQ(int[] disorderqq ) {
        Queue q=new LinkedList();
        int[] qq=new int[disorderqq.length];
        for (int i = disorderqq.length-1; i >=0 ; i--) {
            if(!q.isEmpty()){
                q.add(q.poll());
            }
            q.add(disorderqq[i]);
        }

       Iterator it=q.iterator();
        int index=qq.length-1;
        while(it.hasNext()){
            qq[index--]= (int)it.next();
        }
        return qq;
    }

    private static int[] getDisOrderQQ(String qq) {
        int[] disOrderQQ=new int[qq.length()];
        int[] originQQ=new int[qq.length()];
        char c;
        for(int i=0;i<qq.length();i++){
            c=qq.charAt(i);
            originQQ[i]=Integer.valueOf(String.valueOf(c));
        }

        //打乱顺序
        for(int i=0;i<originQQ.length;i++){
            disOrderQQ[i]=originQQ[i];//先抽取originQQ的第一1个号码
            if(i<originQQ.length-1) {
                int tmp = originQQ[i + 1];//将第2个号码放到originQQ的最后
                for (int j = i + 1; j < originQQ.length - 1; j++) {
                    originQQ[j] = originQQ[j + 1];
                }
                originQQ[originQQ.length - 1] = tmp;
            }
        }
        return disOrderQQ;
    }
}
