//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 哈希表

package leetcode.editor.cn;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

class DiYiGeZhiChuXianYiCiDeZiFuLcof{
    public static void main(String[] args) {
        Solution solution = new DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char firstUniqChar(String s) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            for (char c : s.toCharArray()) {
                if (count[c - 'a'] == 1) return c;
            }
            return ' ';
        }

        /**
         * 想复杂了
         * @param
         * @return
         */
        public char firstUniqChar_my(String s) {
            if(s==null ||s.length()==0)return ' ';
            LinkedList<Character> queue=new LinkedList<>();
            Map<Character,Integer> map=new HashMap<>();
            Character first=s.charAt(0);
            queue.add(first);
            map.put(first,1);
            for (int i = 1; i <s.length() ; i++) {
                char ch=s.charAt(i);
                queue.add(ch);
                if(map.containsKey(ch)){
                    map.put(ch,map.get(ch)+1);
                }else{
                    map.put(ch,1);
                }
                while(!queue.isEmpty()&&map.get(first=queue.peekFirst())>1){
                    queue.poll();
                }
                if(map.get(first)>1)first=' ';
            }
            return first;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}