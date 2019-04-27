package rechard.learn.leecode;

/**
 *
 */
public class Q_28strStr {
    public int strStr(String haystack, String needle) {
        if(needle==null||haystack==null||haystack.length()<needle.length()) return -1;
        if(needle.length()==0)return 0;
        int firstChar=needle.charAt(0);

        out:for(int i=0;(haystack.length()-i)>=needle.length();){
            if(haystack.charAt(i)==firstChar){
                int moveStep=-1;
                for(int j=1;j<needle.length();j++){

                    if(moveStep==-1&&firstChar==haystack.charAt(i+j))
                        moveStep=j;

                    if(needle.charAt(j)!=haystack.charAt(i+j)){
                        i+= (moveStep=moveStep==-1?1:moveStep);
                        continue out;
                    }
                }
                return i;
            }else{
                i++;
            }
        }
        return -1;
    }
}
