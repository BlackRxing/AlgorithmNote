package dp;
//该题的dp定义特别重要，dp[i]表示包括下标i的最大连续序列之和，才有该递推公式成立
public class _53_maximm_subarray {
    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }

            int res = nums[0];
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                res = res > dp[i] ? res : dp[i];
            }
            return res;
        }
    }
}
