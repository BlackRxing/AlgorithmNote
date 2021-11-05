package dp;
//想到利用动态规划就会迎刃而解，相当于最长子序列的升级版，需要计算出匹配的个数
public class _115_ditinct_subsequence {
    class Solution {
        public int numDistinct(String s, String t) {
            int[][] dp=new int[t.length()+1][s.length()+1];
            for(int i=0;i<=s.length();i++){
                dp[0][i]=1;
            }
            for(int i=1;i<=t.length();i++){
                for(int j=1;j<=s.length();j++){
                    if(s.charAt(j-1)==t.charAt(i-1)){
                        dp[i][j]=dp[i-1][j-1]+dp[i][j-1];
                    }else{
                        dp[i][j]=dp[i][j-1];
                    }
                }
            }
            return dp[t.length()][s.length()];
        }
    }
}
