package rechard.learn.leecode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 找出不含有重复字符的最长子串的长度
 */
public class LengthOfLongestSubstring {



    public int findLengthOfLongestSubstring_error(String str){
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
                while(str.charAt(i++)!=ch);
                set.remove(ch);
            }
        }
        return longest;
    }

    public int findLengthOfLongestSubstring(String s){
        if(s==null) return 0;
        HashSet set = new HashSet();
        int longest=0;
        int i=0,j=0;
        while(j<s.length()){
            char ch=s.charAt(j);
            if(!set.contains(ch)){
                set.add(ch);
                longest=Math.max(longest,j-i+1);
                j++;
            }else{
                while(set.contains(ch))
                    set.remove(s.charAt(i++));
            }
        }
        return longest;
    }

    //leecode 版本1 使用 hashset

    /**
     *思路是定义i,j,i 到j 一定是不重复的
     * 将i到j的对应的char都放到set里，
     * j不断的增加，一旦set里有j的值，那么i一个个往前，set里去掉i对应的char直到set里不再包含j重复的那个char
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s){
        if(s==null) return 0;
        Set set=new HashSet();
        int longest=0;
        for(int j=0,i=0;j<s.length();){
            //当hashset里没有包含某个字符的时候
            if(!set.contains(s.charAt(j))){
                //加入这个字符
                set.add(s.charAt(j));
                //现在的长度和最大的长度之间谁更大就选谁
                longest=longest<j-i+1?j-i+1:longest;
                j++;
            }else{
                while(set.contains(s.charAt(j))) {
                    set.remove(s.charAt(i++));
                }
            }
        }
        return longest;
    }
    //leecode 版本2 使用 hashmap

    /**
     * 再1的版本上更进一步，不需要i一个个的加，直接可以判断到i重复的那个位置
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_2(String s) {
        if(s==null) return 0;
        HashMap<Character,Integer> m = new HashMap();
        int longest=0,i=0,j=0;
        while(j<s.length()){
            if(m.get(s.charAt(j))!=null){
                i=Math.max(i,m.get(s.charAt(j))+1);
            }
            longest=Math.max(longest,j-i+1);
            m.put(s.charAt(j),j++);
        }
        return longest;
    }

    public static void main(String[] args) {
        int l = new LengthOfLongestSubstring().lengthOfLongestSubstring("bbbbb");
        System.out.println(l);
    }
}
