package rechard.learn.leecode;

/**
 * 求平方根
 */
public class Squr {

    public static int squr(int x){
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

    public static void main(String[] args) {
        System.out.println(Math.sqrt(Integer.MAX_VALUE));
        System.out.println(squr(Integer.MAX_VALUE));
        for(int i=0;i<Integer.MAX_VALUE;i++){
            System.out.println(Math.sqrt(i));
            System.out.println(squr(i));
            System.out.println("------------");
        }
    }
}
