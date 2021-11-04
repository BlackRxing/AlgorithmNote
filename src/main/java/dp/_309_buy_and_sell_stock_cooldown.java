package dp;
//2的升级版，多了一个冷却日，多了两种情况
//0：当日结束持有股票
//1:当日结束无股票，已经历过冷却日
//2:无股票，当天抛售
//3:冷却日
public class _309_buy_and_sell_stock_cooldown {
    class Solution {
        public int maxProfit(int[] prices) {
            int dp[][]=new int[prices.length][4];
            dp[0][0]=-prices[0];
            for(int i=1;i<prices.length;i++){
                dp[i][0]=Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][3])-prices[i]);
                dp[i][1]=Math.max(dp[i-1][1],dp[i-1][3]);
                dp[i][2]=dp[i-1][0]+prices[i];
                dp[i][3]=dp[i-1][2];
            }
            return Math.max(dp[prices.length-1][1],Math.max(dp[prices.length-1][2],dp[prices.length-1][3]));
        }
    }
}
