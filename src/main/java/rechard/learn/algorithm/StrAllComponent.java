package rechard.learn.algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.TreeSet;
/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c
 * 所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。 结果请按字母顺序输出。
   输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * @param str
 * @return
 */
public class StrAllComponent {
	public ArrayList<String> permutation(String str) {
		ArrayList<String> result = new ArrayList<String>(); 
		permutation(str, 0,result);
		return result;
	}
	private void permutation(String str,int swapIndex, ArrayList<String> result) {
		char[] chars = str.toCharArray();
		String nstr = null;
		for(int j=swapIndex;j<chars.length-1;j++){
			nstr = new String(swap(chars,swapIndex,j+1));
			permutation(nstr,j+1,result);
			if(swapIndex==chars.length-1)
				result.add(nstr);
		}
		permutation(str,swapIndex+1,result);
	}
	private char[] swap(char[] chars, int i,int j){
		char[] nchars = chars;
		char tmp = nchars[i];
		nchars[i] = nchars[j];
		nchars[j] = tmp;
		return nchars;
	}
	public static void main(String[] args) {
		ArrayList<String> result = new StrAllComponent().Permutation("abc");
		Iterator<String> it = result.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}



	public ArrayList<String> Permutation(String str) {
		TreeSet<String> tree = new TreeSet<>();
		Stack<String[]> stack = new Stack<>();
		ArrayList<String> results = new ArrayList<>();
		stack.push(new String[]{str,""});
		do{
			String[] popStrs = stack.pop();
			String oldStr = popStrs[1];
			String statckStr = popStrs[0];
			for(int i =statckStr.length()-1;i>=0;i--){
				String[] strs = new String[]{statckStr.substring(0,i)+statckStr.substring(i+1),
						oldStr+statckStr.substring(i,i+1)};
				if(strs[0].length()==0){
					tree.add(strs[1]);
				}else{
					stack.push(strs);
				}
			}
		}while(!stack.isEmpty());
		for(String s : tree)
			results.add(s);
		return results;
	}
}
