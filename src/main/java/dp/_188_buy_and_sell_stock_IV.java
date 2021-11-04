package dp;
//3的变化版
public class _188_buy_and_sell_stock_IV {
    class Solution {
        public int maxProfit(int k, int[] prices) {
            if(prices.length==0) return 0;
            int[] dp=new int[2*k+1];
            for(int i=1;i<2*k;i=i+2){
                dp[i]=-prices[0];
            }
            for(int i=1;i<prices.length;i++){  //从后向前遍历
                for(int j=2*k;j>=2;j=j-2){
                    dp[j]=Math.max(dp[j-1]+prices[i],dp[j]);
                    dp[j-1]=Math.max(dp[j-2]-prices[i],dp[j-1]);
                }
            }
            return dp[2*k];
        }
    }
}
