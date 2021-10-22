package dp;
//关键在于理解石块消除问题可以转化成分成两堆的对大差值，比如两个完全消除的问题可以等价于分割成两个和相同的组
public class _101_last_stone_weight_II {
    class Solution {
        public int lastStoneWeightII(int[] stones) {
            int sum=0;
            for(int stone:stones){
                sum+=stone;
            }
            int[] dp=new int[sum+1];
            int length=stones.length;
            for(int i=0;i<length;i++){
                for(int j=sum;j>=stones[i];j--){
                    dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
                }
            }
            int gap=0;
            for(int x=sum/2;x>=0;x--){
                if(dp[x]==x){
                    gap=sum-2*x;
                    break;
                }
            }
            //循环替换成下面这样最简洁
            //return sum - 2 * dp[target];
            return gap;
        }
    }
}
