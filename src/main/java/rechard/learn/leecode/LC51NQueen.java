package rechard.learn.leecode;

import java.util.ArrayList;
import java.util.List;

public class LC51NQueen{
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> res=new ArrayList();
            backtrace(res,new ArrayList<String>(),n);
            return res;
        }

        public void backtrace(List<List<String>> res,List<String> cur,int n){
            if(cur.size()==n){
                res.add(cur);
            }else{
                for(int i=0;i<n;i++){
                    List l=new ArrayList(cur);
                    String str=putQAndGetString(i,n);
                    l.add(str);
                    if(isValid(l,l.size()-1,i,n)){
                        backtrace(res,l,n);
                    }
                }
            }
        }

        private boolean isValid(List<String> cur,int qrow,int qcol,int n){
            //检查同一列
            for(int row=0;row<qrow;row++){
                if(cur.get(row).charAt(qcol)=='Q') return false;
            }
            //检查右上
            for(int row=qrow-1,col=qcol+1;row>=0 && col<n;row--,col++){
                if(cur.get(row).charAt(col)=='Q') return false;
            }
            //检查左上
            for(int row=qrow-1,col=qcol-1;row>=0 && col>=0;row--,col--){
                if(cur.get(row).charAt(col)=='Q') return false;
            }
            return true;
        }

        private String putQAndGetString(int Qindex,int n){
            StringBuilder stringBuilder=new StringBuilder();
            for (int j=0;j<n;j++){
                stringBuilder.append(j==Qindex?'Q':'.');
            }
            return stringBuilder.toString();
        }
    }
}
