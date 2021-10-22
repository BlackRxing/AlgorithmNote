package dp;
//此题算是完全背包问题，如果先item，后重量不容易判断外层循环次数，所以适合先重量后item的嵌套循环
public class _377_combination_sum_IV {
    class Solution {
        public int combinationSum4(int[] nums, int target) {
            int[] dp=new int[target+1];
            dp[0]=1;
            int items=nums.length;
            for(int i=1;i<=target;i++){
                for(int j:nums){
                    if(j<=i){
                        dp[i]+=dp[i-j];
                    }
                }
            }
            return dp[target];
        }
    }
}
