package rechard.learn.leecode;

public class Trie {
    private TrieNode root=null;
    class TrieNode{
        char val;
        TrieNode[] child=new TrieNode[26];
        public TrieNode(){
        }
        public TrieNode(char val){
            this.val=val;
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        this.root=new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur=this.root;
        for(int i=0;i<word.length();i++){
            int c=word.charAt(i)-'a';

            if(cur.child[c]==null){
                cur.child[c]=new TrieNode(word.charAt(i));
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur=this.root;
        for(int i=0;i<word.length();i++){
            int c=word.charAt(i)-'a';

            if(cur.child[c]==null){
                return false;
            }
            cur=cur.child[c];
        }
        return cur.val==word.charAt(word.length()-1);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur=this.root;
        for(int i=0;i<prefix.length();i++){
            int c=prefix.charAt(i)-'a';

            if(cur.child[c]==null){
                return false;
            }
            cur=cur.child[c];
        }
        return true;
    }
}
