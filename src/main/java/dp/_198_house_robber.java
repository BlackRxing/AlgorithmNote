package dp;
//典型动态规划
public class _198_house_robber {
    class Solution {
        public int rob(int[] nums) {
            int[] dp=new int[nums.length+1];
            dp[1]=nums[0];
            for(int i=1;i<nums.length;i++){
                dp[i+1]=Math.max(dp[i-1]+nums[i],dp[i]);
            }
            return dp[nums.length];
        }
    }
}
