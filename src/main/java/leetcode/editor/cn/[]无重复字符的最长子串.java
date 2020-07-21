//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window

package leetcode.editor.cn;

import java.util.*;

class LongestSubstringWithoutRepeatingCharacters{
      public static void main(String[] args) {
           Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
      }
 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

     /**
      * 比不上lengthOfLongestSubstring_3
      * 比上lengthOfLongestSubstring_2
      *
      * 比不上lengthOfLongestSubstring_3 原因应该是查找的效率
      * 数据下标映射要比hashset的查找快的多，hashset事实上是hashmap的key的查找
      *
      * 执行耗时:10 ms,击败了39.75% 的Java用户
      *
      * 内存消耗:40.2 MB,击败了5.20% 的Java用户
       * @param s
      * @return
      */
     public int lengthOfLongestSubstring_4(String s){
         if(s==null)return 0;
         int longest=0;
         Set set=new HashSet<>();
         int i=0;
         for (int j = 0; j <s.length() ; j++) {
             while(set.contains(s.charAt(j))){
                 set.remove(s.charAt(i++));
             }
             set.add(s.charAt(j));
             //longest=Math.max(longest,j-i+1);
             longest=Math.max(longest,set.size());
         }
         return longest;
     }


     /**
      *
      * lengthOfLongestSubstring_3 是在 lengthOfLongestSubstring_2
      * 的基础上使用数组来提代queue
      *
      * 执行耗时:3 ms,击败了96.91% 的Java用户
      * 内存消耗:39.7 MB,击败了5.20% 的Java用户
       * @param s
      * @return
      */
     public int lengthOfLongestSubstring_3(String s) {
         if(s==null)return 0;
         int[] map = new int[128];
         int start = 0, end = 0, len = 0;
         while (end < s.length()) {
             //如果不含有
             if(map[s.charAt(end)]==0){
                 len=Math.max(len,end-start+1) ;
                 map[s.charAt(end)]=1;
             }else{
                 //如果含有，则需要begin到含有字符的那段清除掉
                while(map[s.charAt(end)]!=0){
                    map[s.charAt(start)]=0;
                    start++;
                }
                len=Math.max(len,end-start+1) ;
                map[s.charAt(end)]=1;
             }
             end++;
         }
         return len;
     }


     /**
      * 执行耗时:36 ms,击败了18.46% 的Java用户
      * 比之前的map慢的原因应该还是在于q.contains(ch)需要遍历链表
      * 同时while操作里去除重复元素
      * 内存消耗:39.9 MB,击败了5.20% 的Java用户
       * @param s
      * @return
      */
     public int lengthOfLongestSubstring_2(String s) {
         if(s==null)return 0;
         Queue<Character> q=new LinkedList<>();
         int longest=0;
         for(int i=0;i<s.length();i++){
             char ch=s.charAt(i);
             while(q.contains(ch)){
                 q.poll();
             }
             q.offer(ch);
             longest=Math.max(longest,q.size());
         }
         return longest;
     }

     /**
      * 解法1: 其实自己也想到了，但是错在只考虑了m.get(s.charAt(j))!=null
      * 需要判断最长，应该是每走1步都应该取判断下。另外极端的总结比如：
      * s 为空， 1个长度，都一样
       * @param s
      * @return
      *
      *
      *     执行耗时:7 ms,击败了82.35% 的Java用户
      * 	内存消耗:39.8 MB,击败了5.20% 的Java用户
      */
     public int lengthOfLongestSubstring_1(String s) {
        if(s==null ||s.length()==0)return 0;
       int i=0,j=0,longest=0;

       Map<Character,Integer> m=new HashMap();
       while(j<s.length()){
           if(m.get(s.charAt(j))!=null){
               i=Math.max(i,m.get(s.charAt(j))+1);
           }
           m.put(s.charAt(j),j);
           longest=Math.max(longest,j-i+1);
           j++;
       }
       return  longest;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}