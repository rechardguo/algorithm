package rechard.learn.leecode;

public class LC1162 {

        public int maxDistance(int[][] grid) {
            int max=0;
            int[][] t=new int[grid.length][grid[0].length];
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j]==0){
                        t[i][j]=Math.min(i-1>=0?t[i-1][j]:Integer.MAX_VALUE, j-1>=0?t[i][j-1]:Integer.MAX_VALUE)+1;
                        max=Math.max(max,t[i][j]);
                    }else{
                        int maxup=0;
                        int maxLeft=0;
                        boolean ischange=false;
                        if(i-1>=0&&t[i-1][j]>1){
                            if(t[i-1][j]==max){
                                maxup=Math.max(i-2>=0?t[i-2][j]:0, j-1>=0?t[i-1][j-1]:0);
                                ischange=true;
                            }
                            t[i-1][j]=1;
                        }
                        if(j-1>=0&&t[i][j-1]>1){
                            if(t[i][j-1]==max){
                                maxLeft=Math.max(i-1>=0?t[i-1][j-1]:0, j-2>=0?t[i][j-2]:0);
                                ischange=true;
                            }
                            t[i][j-1]=1;
                        }

                        max=ischange?Math.max(maxup,maxLeft):max;
                    }
                }
            }
            return max==0?-1:max;
        }

    public static void main(String[] args) {
        int[][] g=new int[][]{{1,0,0},{1,0,0},{1,0,1}};
        System.out.println(new LC1162().maxDistance(g));
    }
}
