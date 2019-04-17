package rechard.learn.leecode;

import java.util.HashSet;

/**
 * 找出不含有重复字符的最长子串的长度
 */
public class LengthOfLongestSubstring {

    public int findLengthOfLongestSubstring(String str){
        HashSet set = new HashSet();
        int longest=1;
        int i=0,j=0;
        while(j<str.length()){
            char ch=str.charAt(j);
            if(!set.contains(ch)){
                set.add(ch);
                j++;
                longest=Math.max(longest,j-i);
            }else{
                while(str.charAt(i++)!=ch){
                }
                set.remove(ch);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int l = new LengthOfLongestSubstring().findLengthOfLongestSubstring("pwijawkew");
        System.out.println(l);
    }
}
