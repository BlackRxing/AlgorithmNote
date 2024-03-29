package dp;

public class _416_partition_equal_subset_sum {
    //转化成0-1背包问题，使用滚动数组方法求解，节省空间
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum=0;
            for(int i:nums){
                sum+=i;
            }
            if(sum%2==1){
                return false;
            }
            int weight=sum/2;
            int dp[]=new int[weight+1];
            int size=nums.length;
            for(int i=0;i<size;i++){
                for(int j=weight;j>=nums[i];j--){
                    dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
                }
            }
            if(dp[weight]==weight){
                return true;
            }
            return false;
        }
    }
    //使用二维数组求解，占用空间大
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        testWeightBagProblem(weight, value, bagSize);
    }

    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize){
        int wLen = weight.length, value0 = 0;
        //定义dp数组：dp[i][j]表示背包容量为j时，前i个物品能获得的最大价值
        int[][] dp = new int[wLen + 1][bagSize + 1];
        //初始化：背包容量为0时，能获得的价值都为0
        for (int i = 0; i <= wLen; i++){
            dp[i][0] = value0;
        }
        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 1; i <= wLen; i++){
            for (int j = 1; j <= bagSize; j++){
                if (j < weight[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        //打印dp数组
        for (int i = 0; i <= wLen; i++){
            for (int j = 0; j <= bagSize; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
