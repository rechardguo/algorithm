package rechard.learn.jzoffer;

public class Code_006 {

    public String replaceStr(String str){
        if(str==null)
            return null;
        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)== ' '){
                count+=2;
            }
            count++;
        }
        char [] newChar=new char[count];
        int index=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)== ' '){
                newChar[index++]='%';
                newChar[index++]='2';
                newChar[index++]='0';
            }else{
                newChar[index++]=str.charAt(i);
            }
        }
        return String.valueOf(newChar);
    }
}
