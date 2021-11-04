package dp;

public class _123_buy_and_sell_stock_III {
    class Solution {
        public int maxProfit(int[] prices) {
            int[][] dp=new int[prices.length][4];
            dp[0][0]=-prices[0];
            dp[0][2]=-prices[0];   //这一步很微妙，只能通过举具体例子来分析
            for(int i=1;i<prices.length;i++){
                dp[i][0]=Math.max(dp[i-1][0],-prices[i]);
                dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
                dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]-prices[i]);
                dp[i][3]=Math.max(dp[i-1][3],dp[i-1][2]+prices[i]);
            }
            return dp[prices.length-1][3];
        }
    }
}
