package rechard.learn.leecode;

import com.sun.org.apache.xpath.internal.operations.Plus;

public class Q_66PlusOne {
    public static void main(String[] args) {
        int [] nums=new int[]{8,9,9,9};
        System.out.println(plusOne(nums));
    }
    public static int[] plusOne(int[] digits) {
        return plusOne(digits,digits.length-1);
    }

    private static int[] plusOne(int[] digits,int index) {
        if(digits==null)return null;
        if(index<0){
            int[] ndigits = new int[digits.length+1];
            ndigits[0]=1;
            for(int i=1;i<ndigits.length;i++)
                ndigits[i]=digits[i-1];
            return ndigits;
        }
        int sum=digits[index]+1;
        if(sum>9){
            digits[index]=sum%10;
            return plusOne(digits,index-1);
        }else{
            digits[index]=sum;
        }
        return digits;
    }
}
