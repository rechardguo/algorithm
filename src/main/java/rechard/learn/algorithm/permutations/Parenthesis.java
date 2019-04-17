package rechard.learn.algorithm.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * 求解所有的有效的括号
 */
public class Parenthesis {

    public List<String> geneParenthesis(int n){
        List<String> list=new ArrayList<>();
        geneParenthesis(list,"",0,0,n);
        return list;
    }

    public void geneParenthesis(List<String> list,String str,int open,int close,int max){
        if(close==max){
            list.add(str);
            return;
        }
        if(open<max)
            geneParenthesis(list,str+"(",open+1,close,max);
        if(close<open)
            geneParenthesis(list,str+")",open,close+1,max);
    }

    public static void main(String[] args) {
        List<String> list=new Parenthesis().geneParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
    }

}
