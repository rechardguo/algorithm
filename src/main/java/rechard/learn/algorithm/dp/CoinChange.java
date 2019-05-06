package rechard.learn.algorithm.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 换零钱
 * 
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins=new int[]{1,2,5,8,10};
        System.out.println(moneyChange(coins,18));
    }

    public static int moneyChange(int[] coins,int m){
        Map<Integer,Integer> minMoneyMapping=new HashMap();
        for (int i = 0; i <coins.length ; i++) {
            minMoneyMapping.put(coins[i],1);
        }
       return getMiniChange(coins,m,minMoneyMapping);
    }

    private static int getMiniChange(int[] coins,int m,Map<Integer,Integer> minMoneyMapping){
        if(m==0)return 0;
        if(minMoneyMapping.get(m)!=null)
            return minMoneyMapping.get(m);
        int min=Integer.MAX_VALUE;
        for (int i = 1; i <m ; i++) {
            min=Math.min(min,getMiniChange(coins,i,minMoneyMapping)+getMiniChange(coins,m-i,minMoneyMapping));
        }
        minMoneyMapping.put(m,min);
        return min;
    }
}
