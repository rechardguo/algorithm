package rechard.learn.leecode;

/**
 *思路是：
 *
 * 假设
 * haystack：abcabeabcabc
 * needle：abcabc
 *
 * 第一次比较i=0
 * 发现abcabc比较到haystack的0-5最后的e不匹配
 * 正常的做法是i=1,在进行abcabc比较到haystack的1-6的比较。
 *
 * 优化的做法
 * haystack[i]必须是a开始才有机会去匹配needle,按照这个想法，在i=0的比较过程中可以记录下是否有和a相同的字符出现过，
 * 有的话就记录到movestep.
 *
 * 例如上面的比较i=0，发现不匹配的话
 * i可以直接跳到3的位置，省去2步。
 * 这个做法就是moveStep的逻辑，也就是看下头字符在比较过程中是否
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
