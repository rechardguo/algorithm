package rechard.learn.leecode;

import java.util.Arrays;

public class LC820 {

    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words,(w1,w2)->{return w2.length()-w1.length();});
        Trie t=new Trie();
        int l=0;
        for(String s:words){
            l+=t.insert(s);
        }
        return l;
    }

    class Trie{
        TrieNode root=new TrieNode(' ');
        public int insert(String w){
            TrieNode cur=root;
            boolean isNew=false;
            for(int i=w.length()-1;i>=0;i--){
                int c=w.charAt(i)-'a';
                if(cur.child[c]==null){
                    cur.child[c]=new TrieNode(w.charAt(i));
                   isNew=true;
                }
                cur=cur.child[c];
            }
           return isNew?w.length()+1:0;
        }
    }

    class TrieNode{
        private char val;
        TrieNode[] child=new TrieNode[26];//26个字符

        public TrieNode(char ch) {
            this.val = ch;
        }
    }
}
