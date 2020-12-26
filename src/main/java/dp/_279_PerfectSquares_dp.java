package dp;

import java.util.Arrays;

public class _279_PerfectSquares_dp {

        public int numSquares(int n) {
            int dp[]=new int[n+1];
            int max=(int)Math.sqrt(n);
            int squares[]=new int[max+1];
            for(int i=0;i<=max;i++){
                squares[i]=i*i;
            }
            Arrays.fill(dp,Integer.MAX_VALUE);
            dp[0]=0;
            for(int i=1;i<=n;i++){
                for(int j=1;j<=max;j++){
                    if(squares[j]>i){
                        break;
                    }
                    dp[i]=Math.min(dp[i],dp[i-squares[j]]+1);
                }
            }
            return dp[n];
        }

}
