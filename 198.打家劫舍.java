/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = nums[0];
        if (nums.length == 1) {
            return max;
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        for (int i = 2; i < nums.length; i++) {
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            // 状态转移方程
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            // 最大值
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
// @lc code=end

