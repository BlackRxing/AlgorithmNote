package dp;

public class _96_unique_binary_search_trees {
//    class Solution {
//        public int numTrees(int n) {
//            int[][] dp=new int[n][n];
//            for(int i=0;i<n;i++){
//                dp[i][i]=1;
//            }
//            for(int i=1;i<n;i++){
//                for(int j=1;j<=n-i;j++){
//                    int start=j-1;
//                    int end=i+j-1;
//                    int sum=0;
//                    int a,b,add;
//                    for(int x=start;x<=end;x++){
//                        System.out.println(start+" "+end+" "+x);
//                        if(start==x){
//                            add=dp[start+1][end];
//                        }else if(end==x){
//                            add=dp[start][end-1];
//                        }else{
//                            add=dp[start][x-1]*dp[x+1][end];
//                        }
//                        sum+=add;
//                    }
//                    dp[start][end]=sum;
//                }
//            }
//            return dp[0][n-1];
//        }
//    }
    //以上的写法没有考虑到相同数量的子问题，比如3-5与7-9是一样的结果，采用了二维数组，实际上一维数组既可以了
class Solution {
    public int numTrees(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;  //不用单独处理数量为0的情况
        dp[1]=1;
        for(int i=2;i<=n;i++){
            int sum=0;
            for(int j=1;j<=i;j++){
                sum+=dp[j-1]*dp[i-j];
            }
            dp[i]=sum;
        }
        return dp[n];
    }
}
}
