package dp;
//可以转化为求最长公共子序列问题，也可以直接利用动态规划，dp[i][j]代表word1到下标i-1以及word2到下标j-1删除到所需的最小次数
public class _583_delete_operation_for_two_strings {
    class Solution {
        public int minDistance(String word1, String word2) {
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];
            for (int i = 0; i < word1.length() + 1; i++) dp[i][0] = i;
            for (int j = 0; j < word2.length() + 1; j++) dp[0][j] = j;

            for (int i = 1; i < word1.length() + 1; i++) {
                for (int j = 1; j < word2.length() + 1; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }else{
                        dp[i][j] = Math.min(dp[i - 1][j - 1] + 2,
                                Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                    }
                }
            }

            return dp[word1.length()][word2.length()];
        }
    }
}
