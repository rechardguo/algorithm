//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
//

package leetcode.editor.cn;
class TiHuanKongGeLcof{
      public static void main(String[] args) {
           Solution solution = new TiHuanKongGeLcof().new Solution();
      }
 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
     //击败了100.00% 的Java用户
     // 以空间换时间
     public String replaceSpace(String s) {
         if(s==null)return null;
         char[] chars=new char[s.length()*3];
         int index=0;
         for (int i = 0; i <s.length() ; i++) {
             char ch=s.charAt(i);
             if(ch==' '){
                 chars[index++]='%';
                 chars[index++]='2';
                 chars[index++]='0';
             }else{
                 chars[index++]=ch;
             }
         }
         return new String(chars,0,index);

     }

     /**
      * 击败了17.90% 的Java用户
      * 估计是字符串链接操作耗时
       * @param s
      * @return
      */
     public String replaceSpace_1(String s) {
        if(s==null)return null;
        String s2="";
        int index=0;
        while(index<s.length()) {
            char ch = s.charAt(index);
            if (ch == ' ') {
                s2+="%20";
            }else{
                s2+=String.valueOf(ch);
            }
            index++;
        }
        return s2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}