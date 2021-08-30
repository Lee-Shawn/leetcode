/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int f0 = -prices[0];
        int f1 = 0;
        int f2 = 0;
        for (int i = 1; i < n; i++) {
            // f0 i-1天手里有股票，f2 i-1天手里没股票且不处于冷冻期，i天买入股票
            int newF0 = Math.max(f0, f2 - prices[i]);
            // i-1天手里持有股票
            int newF1 = f0 + prices[i];
            // i-1天不持有股票，f1 处于冷冻期 f2 不处于冷冻期
            int newF2 = Math.max(f1, f2);
            f0 = newF0;
            f1 = newF1;
            f2 = newF2;
        }
        return Math.max(f1, f2);
    }
}
// @lc code=end

