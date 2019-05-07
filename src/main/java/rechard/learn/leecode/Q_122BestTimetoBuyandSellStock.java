package rechard.learn.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * 股票买卖，这个思路好难想
 */
public class Q_122BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    public int maxProfit_mine(int[] prices) {
        Map<String,Integer> priceMap=new HashMap();
        return maxProfit_0(prices,0,prices.length,priceMap);
    }

    public int maxProfit_0(int[] prices,int i,int j, Map<String,Integer> priceMap) {
        int maxProfit=0;
        if(priceMap.get(i+"-"+j)!=null)
            return priceMap.get(i+"-"+j);

        for(int z=i;z<j-1;z++){
            for(int x=z+1;x<j;x++){
                int p=prices[x]-prices[z];
                priceMap.put(x+"-"+z,p);
                if(p>0){
                    maxProfit=Math.max(p+maxProfit_0(prices,x,j,priceMap),maxProfit);
                }
            }
        }
        priceMap.put(i+"-"+j,maxProfit);
        return maxProfit;
    }
}

