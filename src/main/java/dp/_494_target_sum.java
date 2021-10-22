package dp;

public class _494_target_sum {
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            int sum=0;
            for (int i = 0; i < nums.length; i++) sum += nums[i];
            if((target+sum)%2!=0){   //target和sum必须同奇数偶数，否则size变成小数了
                return 0;
            }
            if(Math.abs(target)>sum) return 0; //否则size可能是负数
            int size=(sum+target)/2;     //这里加或者减是一样的，target是正数就是size较大的那个值，是负数就是较小的值
            int[] dp=new int[size+1];
            dp[0]=1;   //初始化，举个例子就懂了
            for(int i=0;i<nums.length;i++){
                for(int j=size;j>=nums[i];j--){
                    dp[j]+=dp[j-nums[i]];  //加号容易漏掉
                }
            }
            return dp[size];
        }
    }
    //较慢方法最坏可能O(n^2)
//    class Solution {
//        public int findTargetSumWays(int[] nums, int target) {
//            int sum=0;
//            for (int i = 0; i < nums.length; i++) sum += nums[i];
//            if((target+sum)%2!=0){
//                return 0;
//            }
//            if(Math.abs(target)>sum) return 0;
//            int size=(sum+target)/2;
//            int[] dp=new int[size+1];
//            dp[0]=1;
//            for(int i=0;i<nums.length;i++){
//                for(int j=size;j>=nums[i];j--){
//                    dp[j]+=dp[j-nums[i]];
//                }
//            }
//            return dp[size];
//        }
//    }
}
