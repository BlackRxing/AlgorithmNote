package dp;

public class
_213_house_robber_II {
    class Solution {
        public int rob(int[] nums) {
            if(nums.length==1){  //如果长度为1会13行会出现数组越界的情况
                return nums[0];
            }
            //分为包含最后一个位置和不包含最后一个位置的情况
            return Math.max(dpProcess(nums,1,nums.length-1),dpProcess(nums,2,nums.length));
        }
        public int dpProcess(int[] nums,int start,int end){
            int[] dp=new int[nums.length];
            dp[1]=nums[start-1];
            for(int i=2;i<=nums.length-1;i++){
                int pos=start+i-2;
                dp[i]=Math.max(dp[i-1],dp[i-2]+nums[pos]);
            }
            return dp[nums.length-1];
        }
    }
}
