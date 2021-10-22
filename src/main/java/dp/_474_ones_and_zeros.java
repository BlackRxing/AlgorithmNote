package dp;
//本质上还是01背包问题，只不过是二维的，背包有两个维度限制
public class _474_ones_and_zeros {
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            int[][] dp=new int[m+1][n+1];
            for(String str:strs){
                int a=0,b=0;
                for(char c:str.toCharArray()){
                    if(c=='0'){
                        a++;
                    }else{
                        b++;
                    }
                }
                for(int i=m;i>=a;i--){
                    for(int j=n;j>=b;j--){
                        dp[i][j]=Math.max(dp[i-a][j-b]+1,dp[i][j]);
                    }
                }
            }
            return dp[m][n];
        }
    }
}
