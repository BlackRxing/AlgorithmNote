package greedy;
//假如第0天买入，第3天卖出，那么利润为：prices[3] - prices[0]。
//
//相当于(prices[3] - prices[2]) + (prices[2] - prices[1]) + (prices[1] - prices[0])。
//
//此时就是把利润分解为每天为单位的维度，而不是从0天到第3天整体去考虑！
//
//那么根据prices可以得到每天的利润序列：(prices[i] - prices[i - 1]).....(prices[1] - prices[0])。
//收割每一寸利润最后就是最大利润
public class _122_buy_and_sell_stock_II {
    class Solution {
        public int maxProfit(int[] prices) {
            int result = 0;
            for (int i = 1; i < prices.length; i++) {
                result += Math.max(prices[i] - prices[i - 1], 0);
            }
            return result;
        }
    }
}
