package dp;

public class _122_buy_and_sell_stock_II {
    //一种意义上的贪心
    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        int money = root.val;
        if (root.left != null) {
            money += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            money += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(money, rob(root.left) + rob(root.right));
    }
    //动态规划思想，dp[i][0]代表第i天结束没有持有股票（可能当天卖掉也可能今天卖掉）的最大收益，1代表第i天结束持有股票的最大收益
    class Solution {
        public int maxProfit(int[] prices) {
            int[][] dp=new int[prices.length][2];
            dp[0][1]=-prices[0];
            for(int i=1;i<prices.length;i++){
                dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
                dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            }
            return dp[prices.length-1][0];
        }
    }
    //动态规划存储变量写法
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp0 = 0, dp1 = -prices[0];  // 定义变量，存储初始状态
        for (int i = 1; i < n; ++i) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);    // 第 i 天，没有股票
            int newDp1 = Math.max(dp1, dp0 - prices[i]);    // 第 i 天，持有股票
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }
}
