package dp;

class _494 {
    public int findTargetSumWays(int[] nums, int S) {
        int[] dp=new int[2001];
        dp[1000+nums[0]]=1;
        dp[1000-nums[0]]+=1;//这一步+=很重要如果num[0]=0,那么dp[0]=2!!!
        for(int i=1;i<nums.length;i++){
            int[] next=new int[2001];
            for(int j=0;j<=2000;j++){
                if(dp[j]>0){
                    next[j+nums[i]]+=dp[j];
                    next[j-nums[i]]+=dp[j];
                }
            }
            dp=next;
        }
        return S>1000?0:dp[S+1000];
    }
}
