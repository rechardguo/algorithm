package rechard.learn.leecode;

/**
 * 一个M*N的矩阵，元素取值1或0，问如何找到最大的正方形
 */
public class findBigestSquareInNMMatrix {

    public static void main(String[] args) {
        int matrix[][]=new int[][]{
                {1,1,1,1},
                {1,0,1,0},
                {1,1,1,1}
        };
        int result=sulution(matrix);
        System.out.println(result);
    }

    public static int sulution(int matrix[][]){
        if(matrix==null) return 0;
        int m=matrix.length;
        if(m==0) return 0;
        int n=matrix[0].length;
        int smalller=n<m?n:m;
        int largest=1;
        for(int i=0;i<smalller;i++){
            for(int j=0;j<smalller;){
                largest=Math.max(largest,findLargestSquare(i,j,matrix));
                j+= largest+1;
            }
            i+= largest+1;
        }
        return largest*largest;
    }



    //找到其中最大的那块，不管元素是0，还是1 ，运行这个请把
    //findLargestSquare里的改成 int number=matrix[i][j];
    public static int sulution_all(int matrix[][]){
        if(matrix==null) return 0;
        int m=matrix.length;
        if(m==0) return 0;
        int n=matrix[0].length;
        int largest=1;
        int small=n<m?n:m;
        for(int i=0;i<small;i++){
            for(int j=0;j<small;j++){
                largest=Math.max(largest,findLargestSquare(i,j,matrix));
            }
        }
        return largest*largest;
    }

    /**
     * 从i,j开始
     * 每步i+1,j+1
     * 然后[i+1，j+1] 到[i+1，j]都为1
     * 并且
     * [i+1，j+1] 到[i+1，j+1] 都为1
     *
     * 那么就可以认为1,j 到 1+1,j+1 为正方形
     *
     * 已经直到1,j 到 1+1,j+1为正方形的情况下，只要重复上面的+1 就可以判断
     * 1,j 到 i+1+1,j+1+1 是否为正方形，
     * 如果碰到不满足的，直接放回即可
     *
     * @param i
     * @param j
     * @param matrix
     * @return
     */
    private static int findLargestSquare(int i,int j,int matrix[][]){
        int x=i+1,y=j+1,m=matrix.length,n=matrix[0].length;
        int small=n<m?n:m;
        int number=1/*matrix[i][j]*/;
        int largest=1;
        while(x<small&&y<small){
            for(int z=x;z>=i;z--){
                if(matrix[z][y]!=number) {
                    return largest;
                }
            }
            for(int z=y;z>=j;z--){
                if(matrix[x][z]!=number) {
                    return largest;
                }
            }
            largest=(x-i+1);
            x++;
            y++;
        }
        return largest;
    }
}
