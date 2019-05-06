package rechard.learn.algorithm.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 换零钱
 *列出最小的方案
 * 
 */
public class CoinChange2 {

    public static void main(String[] args) {
        int[] coins=new int[]{1,2,5,8,10};
        System.out.println(moneyChange(coins,11));
    }

    public static List<Integer> moneyChange(int[] coins,int m){
        Map<Integer,List<Integer>> money_minCoinComp=new HashMap();//金钱数对应最小的coin数的coin组成
        for (int i = 0; i <coins.length ; i++) {
            List l=new ArrayList<>();
            l.add(coins[i]);
            money_minCoinComp.put(coins[i],l);
        }
       return getMiniChange(coins,m,money_minCoinComp);
    }

    private static List<Integer> getMiniChange(int[] coins,int m,
                                               Map<Integer,List<Integer>> money_minCoinComp){
        if(m==0)return null;
        if(money_minCoinComp.get(m)!=null) {
            return money_minCoinComp.get(m);
        }
        int min=Integer.MAX_VALUE;
        List<Integer> x,y=null;
        List<Integer> minCoin=null;
        for (int i = 1; i <m ; i++) {
            x=getMiniChange(coins,i,money_minCoinComp);
            y=getMiniChange(coins,m-i,money_minCoinComp);
            if(minCoin==null || minCoin.size()>(x==null?0:x.size())+(y==null?0:y.size())){
                minCoin=new ArrayList<>();
                if(x!=null)
                  minCoin.addAll(x);
                if(y!=null)
                  minCoin.addAll(y);
                if(minCoin.isEmpty())
                    minCoin=null;
            }
        }
        money_minCoinComp.put(m,minCoin);
        return minCoin;
    }
}
