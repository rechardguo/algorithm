package rechard.learn.leecode;

/**
 * 最长的回文
 *
 * ababc 找到 aba 或 bab
 *
 *
 * 动态规划：
 * 如果已经知道1+1+1+1=4
 * 那么很容易知道1+1+1+1+1=5
 *
 * 规律:是能否再当前的条件里得出和已经知道的条件的关系
 *
 */
public class LongestPalindrome{
    public static String sulution(String str){
        if(str==null||str.trim().equals(""))return null;
        int n=str.length();
        //定义一个boolean[n][n]的数组
        boolean [][] result=new boolean[n][n];
        String longestStr=String.valueOf(str.charAt(0));
        for(int i=n-1;i>=0;i--){
            int tmp=i;
            for(int j=tmp;j<n;j++){
                //j=tmp的话，就是自己肯定是true
                //如果j和tmp相邻的话j-tmp==1，判断是否j和tmp的字符是否相等，例如xaab,j=1,tmp=2那么1到2就是回文
                if(j-tmp==0|| (j-tmp==1&&str.charAt(tmp)==str.charAt(j))) {
                    result[tmp][j] = true;
                    if(j-tmp+1>longestStr.length())
                        longestStr=str.substring(tmp,j+1);
                }else if(tmp>0&&result[tmp--][j-1]){
                    //如果j和tmp之间的距离大于1，例如xcabacb, tmp=2,j=5,
                    //那么index=2和index=4 已经知道在result里为true,那么知道1和5相等即可知道1到5是一个回文串
                    //由于tmp-- 可能越界，例如abaa  ,tmp=0,j=2,这时候不能再进行tmp--了，所以要有 tmp>0的判断
                    if(str.charAt(tmp)==str.charAt(j)){
                        result[tmp][j]=true;
                        if(j-tmp+1>longestStr.length())
                            longestStr=str.substring(tmp,j+1);
                    }
                }
            }
        }
        return  longestStr;
    }

    public static void main(String[] args) {
        System.out.println(sulution("42343242134sfsfsfad22eesdfasfdsdf"));
    }
}
