package rechard.learn.leecode;

public class LC6 {

   static class Solution {
        public String convert(String s, int numRows) {
            if(s==null||s.length()==0)return s;
            StringBuilder [] sb=new StringBuilder[numRows];
            for(int z=0;z<sb.length;z++)
                sb[z]=new StringBuilder();
            int i=0;
            while(i<s.length()){
                for(int j=0;j<numRows&&i<s.length();j++){
                    sb[j].append(s.charAt(i++));
                }
                for(int j=numRows-2;j>0&&i<s.length();j--){
                    sb[j].append(s.charAt(i++));
                }
            }
            for(int z=1;z<sb.length;z++){
                sb[0].append(sb[z]);
            }
            return sb[0].toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convert("LEETCODEISHIRING",3));
    }
}
