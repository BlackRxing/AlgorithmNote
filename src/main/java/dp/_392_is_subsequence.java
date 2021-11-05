package dp;
//和1035,1143本质一模一样，即求最长公共子序列
public class _392_is_subsequence {
    class Solution {
        public boolean isSubsequence(String s, String t) {
            int[][] dp=new int[s.length()+1][t.length()+1];
            for(int i=1;i<=s.length();i++){
                for(int j=1;j<=t.length();j++){
                    if(s.charAt(i-1)==t.charAt(j-1)){
                        dp[i][j]=dp[i-1][j-1]+1;
                    }else{
                        dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                    }
                }
            }
            return dp[s.length()][t.length()]==s.length()?true:false; //题目规定了s属于t的子序列
        }
    }
}
