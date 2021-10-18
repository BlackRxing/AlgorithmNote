package dp;

public class _343_integer_break {
    class Solution {
        public int integerBreak(int n) {
            int[] dp=new int[n+1];
            dp[1]=1;
            dp[2]=1;
            for(int i=3;i<=n;i++){
                for(int j=1;j<=i/2;j++){
                    dp[i]=Math.max(dp[i],Math.max(j*(i-j),Math.max(j*dp[i-j],Math.max(dp[j]*dp[i-j],dp[j]*(i-j)))));  //要考虑到数字不拆分的情况
                }
            }
            return dp[n];
        }
    }
}
