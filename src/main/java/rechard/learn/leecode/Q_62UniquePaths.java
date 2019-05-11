package rechard.learn.leecode;

public class Q_62UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(2,2));
    }

    public static int uniquePaths(int m, int n) {
        int[][] uniquePathMap=new int[m][n];
        return uniquePaths(m-1,n-1,uniquePathMap);
    }

    public static int uniquePaths(int m,int n,int[][] uniquePathMap) {
        if(m==0){
            uniquePathMap[m][n]=1;
            return 1;
        }
        if(uniquePathMap[m][n]!=0)
            return uniquePathMap[m][n];


        int count=0;
        for(int j=0;j<=n;j++){
            count+=uniquePaths(m-1,j,uniquePathMap);
        }

        uniquePathMap[m][n]=count;
        return count;
    }
}
