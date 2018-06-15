package rechard.learn.algorithm;

public class ReplaceEmptyWord {

	public static void main(String[] args) {
		System.out.println(new ReplaceEmptyWord().replaceSpace(new StringBuffer("We Are Happy")));

	}

	public String replaceSpace(StringBuffer str) {
		int len = str.length();
		int i = 0;
		StringBuffer newStr = new StringBuffer();
		while(i<len){
			char ch = str.charAt(i);
			if(ch==' '){
				newStr.append('%').append('2').append('0');
			}else{
				newStr.append(ch);
			}
			i++;
		}
		return newStr.toString();
    }
}
