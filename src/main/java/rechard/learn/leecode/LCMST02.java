package rechard.learn.leecode;

public class LCMST02 {
    public boolean CheckPermutation(String s1, String s2) {
       char[] char1=s1.toCharArray();
       char[] char2=s2.toCharArray();
       if (char1.length!=char2.length)return false;
       int[] tmp=new int[256];

       for(int i=0;i<char1.length;i++){
           tmp[char1[i]]++;
       }

       for(int j=0;j<char2.length;j++){
           if(tmp[char2[j]]==0){
               return false;
           }else{
               tmp[char2[j]]--;
           }
       }
        return true;
    }


}
