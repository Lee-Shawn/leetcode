/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        // 边界条件
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            // 转移公式
            dp[i] = Math.max(dp[i-1], 0) + nums[i];
            // 最大值
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
// @lc code=end

