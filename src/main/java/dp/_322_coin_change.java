package dp;
//此题属于完全背包，不属于排列或组合，所以两种循环都可以使用，初始化非常重要，可以是max_integer或者amount+1，
// max_integer加一后变成负数，需要加上注释的那一行
public class _322_coin_change {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp=new int[amount+1];
            for(int i=1;i<=amount;i++){
                dp[i]=amount+1;
            }
            for(int i=0;i<coins.length;i++){
                for(int j=coins[i];j<=amount;j++){
                    // if(dp[j-coins[i]]==Integer.MAX_VALUE) continue;
                    dp[j]=Math.min(dp[j-coins[i]]+1,dp[j]);
                }
            }
            return dp[amount]==amount+1?-1:dp[amount];
        }
    }
}
