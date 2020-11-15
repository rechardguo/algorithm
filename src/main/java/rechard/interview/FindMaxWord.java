package rechard.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * 从一段文本里找到最多出现的那个单词，
 * 如果有多个单词相同的话，就返回其中一个
 */
public class FindMaxWord {

    public static void main(String[] args) {
        System.out.println(find());
    }
    //maxword=b
    //aaa 1
    //b 2
    //c 1
    public static String find(){
        String str="aaaacc    cc b   cc b b aaa";
        Map<String,Integer> m=new HashMap<>();
        String maxWord="";
        String word="";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=' '){
                word+=str.charAt(i);
            }else{
                if(word!=""){
                    if(m.get(word)!=null){
                        m.put(word,m.get(word)+1);
                    }else{
                        m.put(word,1);
                    }
                    if(maxWord==""){
                        maxWord = word;
                    }else if (m.get(word)>m.get(maxWord)){
                        maxWord = word;
                    }
                }
                word="";
            }
        }
        return maxWord;
    }
}
