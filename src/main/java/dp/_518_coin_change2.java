package dp;
//完全背包问题
public class _518_coin_change2 {
    class Solution {
        public int change(int amount, int[] coins) {
            int items=coins.length;
            int[] dp=new int[amount+1];
            dp[0]=1;
            for(int i=0;i<items;i++){
                for(int j=coins[i];j<=amount;j++){
                    dp[j]=dp[j]+dp[j-coins[i]];
                }
            }
            return dp[amount];
        }
    }
}
