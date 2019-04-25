package rechard.learn.leecode;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class RevertNumber {

    public static int reverse(int x) {
        int r=0;
        while(x!=0){
            int nr=(r*10)+ (x%10);
            // 如果越界的话,nr/10后肯定和r不等了
            if(nr/10!=r)
                return 0;
            else
                r=nr;
            x/=10;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(reverse(234234299));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE-1);
    }
}
