package rechard.learn.algorithm.dp;

public class BestCut {

    public static void main(String[] args) {
        int []p=new int[]{3,2,5,4,8,7};
        int best=new BestCut().cut2(p,5);
        System.out.println(best);
    }

    public  int cut2(int []p,int n)
    {
        if(n==0)
            return 0;
        int q=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++)
        {
            q=Math.max(q, p[i-1]+cut2(p, n-i));
        }
        return q;
    }

    public int cut(int[]p ,int n){
        if(n==0)
            return 0;
        int max=0;
        for(int i=1;i<=n;i++){
            max=Math.max(max,p[i-1]+cut(p,n-i));
        }
        return max;
    }
}
