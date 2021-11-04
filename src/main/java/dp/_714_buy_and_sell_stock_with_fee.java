package dp;
//在第II类问题基础上减去fee即可
public class _714_buy_and_sell_stock_with_fee {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int[] dp=new int[2];
            dp[0]=-prices[0];
            for(int i=1;i<prices.length;i++){
                int tempa=Math.max(dp[0],dp[1]-prices[i]);
                int tempb=Math.max(dp[1],dp[0]+prices[i]-fee);
                dp[0]=tempa;
                dp[1]=tempb;
            }
            return Math.max(dp[0],dp[1]);  //减去fee之后的确可能变少
        }
    }
}
