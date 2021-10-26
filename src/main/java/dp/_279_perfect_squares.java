package dp;
//完全背包问题，求较小值，两种嵌套皆可
public class _279_perfect_squares {
    class Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        for(int i=1;i<=n;i++){
            dp[i]=n+1;
        }
        for(int i=1;i*i<=n;i++){
            for(int j=i*i;j<=n;j++){
                dp[j]=Math.min(dp[j-i*i]+1,dp[j]);
            }
        }
        return dp[n];
    }
}

}
