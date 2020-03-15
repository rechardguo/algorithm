package rechard.learn.leecode;

public class LC695 {
    static class Solution {
        int max;
        public int maxAreaOfIsland(int[][] grid) {
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    scan(grid,i,j,0);
                }
            }
            return max;
        }

        public void scan(int[][] grid,int i,int j,int _tempMax){
            if(i<0||i>=grid.length||j<0||j>=grid[0].length){
                max=Math.max(max,_tempMax);
            }else{
                if(grid[i][j]==0){
                    max=Math.max(max,_tempMax);
                }else{
                    _tempMax++;
                    grid[i][j]=0;
                    scan(grid,i+1,j,_tempMax);
                    scan(grid,i-1,j,_tempMax);
                    scan(grid,i,j+1,_tempMax);
                    scan(grid,i,j-1,_tempMax);
                }
            }
        }
    }

    public static void main(String[] args) {

      /*  int[][] island=new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};*/


        int[][] island2= {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println(new Solution().maxAreaOfIsland(island2));
    }
}
