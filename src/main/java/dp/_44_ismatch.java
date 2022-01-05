package dp;

public class _44_ismatch {
    class Solution {
        public boolean isMatch(String s, String p) {
            int m=p.length();
            int n=s.length();
            int flag;
            boolean[][] dp=new boolean[m+1][n+1];
            dp[0][0]=true;
            for(int i=1;i<=m;i++){        //初始化要注意
                if(p.charAt(i-1)!='*'){
                    break;
                }
                dp[i][0]=true;
            }
            for(int i=1;i<=m;i++){
                for(int j=1;j<=n;j++){
                    if(p.charAt(i-1)=='?'){
                        dp[i][j]=dp[i-1][j-1];
                    }else if(p.charAt(i-1)=='*'){
                        dp[i][j]=dp[i-1][j]||dp[i][j-1];       //这一步非常重要
                    }else{
                        dp[i][j]=dp[i-1][j-1]&&p.charAt(i-1)==s.charAt(j-1);
                    }
                }
            }
            return dp[m][n];
        }
    }


}
