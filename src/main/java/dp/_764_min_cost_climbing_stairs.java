package dp;

public class _764_min_cost_climbing_stairs {
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int height=cost.length;
            int[] fn=new int[height+1];
            fn[0]=0;
            fn[1]=0;
            for(int i=2;i<=height;i++){
                fn[i]=Math.min(fn[i-1]+cost[i-1],fn[i-2]+cost[i-2]);
            }
            return fn[height];
        }
    }
}
