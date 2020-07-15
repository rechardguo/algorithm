//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集

package leetcode.editor.cn;

class SurroundedRegions{
      public static void main(String[] args) {
           Solution solution = new SurroundedRegions().new Solution();
           solution.solve(new char[][]{{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}});
      }
 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
     public void solve(char[][] board) {
         if (board == null || board.length == 0)
             return;
          int rows=board.length;
          int cols=board[0].length;
          //虚拟节点
          int dummy=rows*cols;
          // 0 到 m*n 个数为m*n
         UnionFind uf=new UnionFind(rows*cols+1);
         for (int i = 0; i <rows; i++) {
             for (int j = 0; j <cols ; j++) {
                 //边界节点为‘O’
                 if(board[i][j]=='O'){
                     if(  i==0 || j==0 || i==rows-1 || j==cols-1 ){
                         uf.union(dummy,node(i,j,cols));
                     }else{
                         if (i > 0 && board[i - 1][j] == 'O')
                             uf.union(node(i, j,cols), node(i - 1, j,cols));
                         if (j > 0 && board[i][j - 1] == 'O')
                             uf.union(node(i, j,cols), node(i, j - 1,cols));

                         //找下
                         if(i+1<rows && board[i+1][j]=='O'){
                             uf.union(dummy,node((i+1),j,cols));
                         }
                         //找右
                         if(j+1<cols && board[i][j+1]=='O'){
                             uf.union(dummy,node(i,(j+1),cols));
                         }
                     }
                 }

             }
         }

         for (int i = 0; i <rows; i++) {
             for (int j = 0; j < cols; j++) {
                if(uf.isUnion(dummy,node(i,j,cols))){
                    board[i][j]='O';
                }else{
                    board[i][j]='X';
                }
             }
         }


     }

     int node(int i, int j,int rows){
        return i*rows+j;
     }

     class UnionFind{
         int [] parents;
         public UnionFind(int n) {
             parents=new int[n];
           for (int i = 1; i < n; i++) {
                 parents[i]=i;
           }
         }
         public int parent(int n){
             //n的父节点指向n的父节点的父节点，保证联通的区域只有一条链
             while(parents[n]!=n){
                 parents[n]=parents[parents[n]];
                 n=parents[n];
             }
             return n;
         }

         public void union(int n1,int n2){
             if(!isUnion(n1,n2))
               parents[n1]= parents[n2];
         }

         public boolean isUnion(int n1,int n2){
             return parent(n1)==parent(n2);
         }

     }
}
//leetcode submit region end(Prohibit modification and deletion)

}