package rechard.learn.leecode;

import java.util.ArrayList;
import java.util.List;

public class LC131 {

    static class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> res=new ArrayList();
            backTrace(s,res,new ArrayList(),0);
            return res;
        }


        public void backTrace(String s,List<List<String>> res, List<String> cur,int start){
            if(start==s.length()){
                res.add(cur);
                return ;
            }
            for(int i=start;i<=s.length();i++){
                String str= s.substring(start,i);
                if(isStringPalindrome(str)){
                    List list=new ArrayList(cur);
                    list.add(str);
                    backTrace(s,res,list,start+1);
                }
            }
        }

        public boolean isStringPalindrome(String s){
            if(s==null||s.length()==0)return false;
            if(s.length()==1)
                return true;
            char[] chars=s.toCharArray();
            int i=0;int j=chars.length-1;
            while(i<j){
                if(chars[i]==chars[j]){
                    i++;j--;
                }else{
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        List<List<String>> res=new Solution().partition("aab");
        System.out.println(res.size());
    }
}
