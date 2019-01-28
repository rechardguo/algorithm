package rechard.learn.algorithm.fibonacci;

// 参考文章 ： https://blog.csdn.net/u013309870/article/details/75193592
public class Fibonacci {

    public static void main(String[] args) {

        for (int i=0;i<30;i++){
           /* if(f1(i)!=f3(i)){
                System.out.println("error");
            }*/
            System.out.println(f1(i)==f3(i));
        }

    }

    //递归算法
    //缺点：比如i=5， f1(5)=f(4)+f(3)  那么f(3)节点会计算2次
    public static int f1(int i){
        if(i<=0)
            return 0;
        else if(i<3)
            return 1;
        else
            return f1(i-1)+f1(i-2);
    }
   //动态规划算法1，使用一个数组保存了已经计算过的值，这样就不用重新算了，避免了递归算法的缺点
    public static int f2(int i){
        if(i<=0)
            return 0;
        else {
            int p[] = new int[i + 1];
            for (int x = 1; x <=i; x++) {
               f2_0(p,x);
            }
            return p[i];
        }
    }
    private  static int f2_0(int[] p,int i){
        if(p[i]!=0)
            return p[i];
        else if(i<3)
            p[i]=1;
        else
            p[i]=p[i-1]+p[i-2];
            return p[i];
    }
    //动态规划算法2，如果传入的i,
    // f(i-2)=f(x)
    // f(i-1)=f(y)
    // f(i)=f(x)+f(y)
    // 这样连数组都不需要使用
    public static int f3(int i){
        if(i<=0)
            return 0;
        else if(i<3)
            return 1;
        else {
            int x_value = 1;
            int y_value = 1;
            int temp = x_value;
            for(int z=2;z<i;z++){
                x_value=y_value;
                y_value+=temp;
                temp=x_value;
            }
            return y_value;
        }


    }

}
