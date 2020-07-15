package rechard.learn.leecode.BFS专题;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LC130 {
    class Solution {
        public void solve(char[][] board) {
            if(board==null) return;
            Queue<int[]> q=new LinkedList();
            HashSet set=new HashSet();
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    if(board[i][j]=='O'){
                        if(i>0 && i<board.length-1 && j>0 && j<board[0].length-1){
                            q.offer(new int[]{i,j});
                            set.add(i*board.length+j);
                        }else{
                            if(checkLinked(set,board.length,i,j)) {
                                for(int z=0;z<set.size();z++){
                                    q.poll();
                                }
                            }
                            set.clear();
                        }
                    }

                }
            }
            while(!q.isEmpty()){
                int[] node=q.poll();
                board[node[0]][node[1]]='X';
            }
        }
        private boolean checkLinked(HashSet set, int m, int i, int j){
            return i-1>=0&&set.contains((i-1)*m+j)
                    ||j-1>=0&&set.contains(i*m+(j-1));
        }
    }

}
