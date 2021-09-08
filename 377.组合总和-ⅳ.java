/*
 * @lc app=leetcode.cn id=377 lang=java
 *
 * [377] 组合总和 Ⅳ
 */

// @lc code=start
class Solution {
    public int combinationSum4(int[] nums, int target) {
        // dp[n]表示target等于n的排列数
        int[] dp = new int[target+1];
        // 不选取任何元素才能为0，只有这一种情况
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    // target = num + (n-num)
                    dp[i] += dp[i-num];
                }
            }
        }
        return dp[target];
    }
}
// @lc code=end

