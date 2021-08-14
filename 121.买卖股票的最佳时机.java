/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int i = 0;
        int profit = 0;
        for (int j = 1; j < prices.length; j++) {
            // 双指针，如果后面的数比前面的小，第一个指针就指向小的数
            if (prices[j] < prices[i]) {
                i = j;
            }
            int max = prices[j] - prices[i];
            if (max > profit) {
                profit = max;
            }
        }
        return profit;
    }
}
// @lc code=end

