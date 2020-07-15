package rechard.learn.leecode;

public class LC322 {
    static class Solution {
        public int coinChange(int[] coins, int amount) {
            if (amount<=0)
                return -1;
            int minCoinNum=-1;
            for(int i=0;i<coins.length;i++){

                int coinNUM=amount/coins[i]; //所需要硬币个数
                int change=amount%coins[i];  // 余下的零钱

                if(change==0&&coinNUM>0){ // 没有零钱了，并且有兑换的硬币数
                    if(minCoinNum==-1){
                        minCoinNum=coinNUM;
                    }else{
                        minCoinNum=Math.min(minCoinNum,coinNUM);
                    }
                }
                if(change>0&&coinNUM>0){

                    int leftcoinNUM=coinChange(coins,change);
                    if (leftcoinNUM!=-1){
                        coinNUM+=leftcoinNUM;
                        if(minCoinNum==-1){
                            minCoinNum=coinNUM;
                        }else{
                            minCoinNum=Math.min(minCoinNum,coinNUM);
                        }
                    }

                }
            }
            return minCoinNum;
        }
    }

    public static void main(String[] args) {
        int res=new Solution().coinChange(new int[]{186,419,83,408},6249);
        System.out.println(res);
    }


}
