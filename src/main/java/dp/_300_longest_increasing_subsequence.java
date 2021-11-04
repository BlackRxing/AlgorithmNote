package dp;

import java.util.Arrays;
//动态规划
public class _300_longest_increasing_subsequence {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] dp=new int[nums.length];
            Arrays.fill(dp,1);
            int ans=0;
            for(int i=0;i<nums.length;i++){
                for(int j=0;j<i;j++){
                    if(nums[i]>nums[j]) dp[i]=Math.max(dp[i],dp[j]+1);
                }
                if(dp[i]>ans) ans=dp[i];
            }
            return ans;
        }
    }
}
