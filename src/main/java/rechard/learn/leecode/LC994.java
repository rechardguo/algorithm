package rechard.learn.leecode;

public class LC994 {
        public int orangesRotting(int[][] grid) {
            int m=grid.length;
            int n=grid[0].length;
            int totalinfeted=0;
            int infeted=0;
            int time=0;
            do{
                System.out.println("round:"+time);
                infeted=0;
                for (int i=0;i<m;i++){
                    for (int j=0;j<n;j++){
                        if(grid[i][j]==2){
                            if(time==0)
                                totalinfeted+=1;
                            if(i-1>=0&&grid[i-1][j]==1){
                                grid[i-1][j]=-2;
                                System.out.println(i-1+","+j);
                                infeted++;
                            }
                            if(i+1<m&&grid[i+1][j]==1){
                                grid[i+1][j]=-2;
                                infeted++;
                                System.out.println(i+1+","+j);
                            }
                            if(j-1>=0&&grid[i][j-1]==1){
                                grid[i][j-1]=-2;
                                infeted++;
                                System.out.println(i+","+(j-1));
                            }
                            if(j+1<n&&grid[i][j+1]==1){
                                infeted++;
                                grid[i][j+1]=-2;
                                System.out.println(i+","+(j+1));
                            }
                        }
                    }
                }
                //将-2转成2
                for (int i=0;i<m;i++){
                    for (int j=0;j<n;j++){
                        if(grid[i][j]==-2)
                            grid[i][j]=2;
                    }
                }

                if (infeted!=0){
                    totalinfeted+=infeted;
                }
                time++;
            }while(infeted!=0);

            int emptycount=0;
            for (int i=0;i<m;i++){
                for (int j=0;j<n;j++){
                    if(grid[i][j]==0){
                        emptycount++;
                    }
                }
            }
            return totalinfeted==(m*n-emptycount)?time-1:-1;
        }

    public static void main(String[] args) {
            int[][] arr=new int [][]{{2,1,1},{1,1,0},{0,1,1}};
            int res=new LC994().orangesRotting(arr);
            System.out.println(res);
    }
}
