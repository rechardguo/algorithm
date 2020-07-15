package rechard.learn.leecode;

public class CL10 {

    static public boolean isMatch(String s, String p) {
        if(s==null||p==null)return false;
        return isMatch(s,s.length()-1,p,p.length()-1);
    }

    public static  boolean isMatch(String s,int i, String p,int j) {
        if(i==-1&&j>=-1)return true;//s匹配完了，p匹配完了，或有余下
        if(j==-1&&i>-1)return false;//p匹配完了，s还有余下的
        if(s.charAt(i)==p.charAt(j)){
            return isMatch(s,i-1,p,j-1);
        }else{
            if(p.charAt(j)=='*'){
                j--;
                if(j<0)return false;
                char ch=p.charAt(j);
                if(ch=='.')return true; //如果是.*
                else{
                    //如果例如 a* 比完所有的s所有的a
                    while(i>=0&&s.charAt(i)==ch)i--;
                    return isMatch(s,i,p,j-1);
                }
            }else if(p.charAt(j)=='.'){
                return isMatch(s,i-1,p,j-1);
            }else{
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println( new CL10().isMatch("mississippi","mis*is*ip*."));
    }
}
