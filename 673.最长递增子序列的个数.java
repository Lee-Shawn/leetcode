/*
 * @lc app=leetcode.cn id=673 lang=java
 *
 * [673] 最长递增子序列的个数
 */

// @lc code=start
class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            count[i] = 1;
        }
        int maxCount = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // 后面的数大于前面的数
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) { // 找到了一个更长的子序列
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) { // 找到了相同长度的最长子序列
                        count[i] += count[j];
                    }
                }
                if (dp[i] > maxCount) {
                    maxCount = dp[i];
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            // 累加最长子序列个数
            if (maxCount == dp[i]) {
                result += count[i];
            }
        }
        return result;
    }
}
// @lc code=end

