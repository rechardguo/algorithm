package rechard.learn.leecode;

/**
 * 求平方根
 */
public class Q_69Squr {

    public static int mySqrt_1(int x){
        if(x<0)
            return 0;
        if(x<=1)
          return x;
        for(int i=1;i<=x/2;i++){
            if(i*i==x||( (i+1)*(i+1)>x  || (i+1)*(i+1)<0)) //i+1)*(i+1)<0为了防止溢出
                return i;
        }
        return 0;
    }

//优于mySqrt_1,是跳跃的时候逼近的时候是通过跳跃，而不是每次+1
    public static int mySqrt(int x) {
        if(x<1)
            return 0;
        int r=1,lastr=r,pf=1;
        while(pf>0&&pf<=x){
            lastr=r;
            r*=2;
            pf=r*r;
        }
        r=lastr;
        pf=r*r;
        while(pf>0&&pf<=x){
            lastr=r;
            r++;
            pf=r*r;
        }
        return lastr;
    }

    public static void main(String[] args) {
       /* System.out.println(Math.sqrt(Integer.MAX_VALUE));
        System.out.println(squr(Integer.MAX_VALUE));
        for(int i=0;i<Integer.MAX_VALUE;i++){
            System.out.println(Math.sqrt(i));
            System.out.println(squr(i));
            System.out.println("------------");
        }*/
        System.out.println(mySqrt(8));
    }
}
