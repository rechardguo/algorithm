package rechard.learn.algorithm.leecode;

//判断数字是否位回文
public class PalindromeNumber {

    /**
     * 思路：通过取数字的高位和地位
     * 例如15351
     * index=1  high 1 low 1
     * index=2  high 5 low 5
     * O(N)
     * @param x
     * @return
     */
    public static  boolean isPalindrome(int x) {
        //if(x<11) //假定负数和个位数不是回文
        //  return false;
        if(x<0)return false;
        int len=1;
        while((x/(int)Math.pow(10,len))!=0)
            len++;
        int index=1;
        while(index<=len/2){
            int low=(x%((int)Math.pow(10,index)))/(int)Math.pow(10,index-1);
            int high=(x/((int)Math.pow(10,len-index)))%10;
            if(low!=high)
                return false;
            index++;
        }
        return true;
    }

    //摘抄于网上,这个不符合题目 If you are thinking of converting the integer to string, note the restriction of using extra space.
    public static boolean isPalindrome2(int x) {
        String xString = x + "";
        int count = 0, length = xString.length(), middle = length / 2;
        for (int i = 0; i < middle; i++) {
            if (xString.charAt(i) == xString.charAt(length - 1 - i)) {
                count++;
            }
        }
        if (count == middle) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<10000;i++) {
         //   System.out.println(isPalindrome(1324));
          //  System.out.println(isPalindrome2(1324));
            if(isPalindrome(i)!=isPalindrome2(i))
               System.out.println("fail for number:"+i);
        }
    }
}
