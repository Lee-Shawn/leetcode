/*
 * @lc app=leetcode.cn id=918 lang=java
 *
 * [918] 环形子数组的最大和
 */

// @lc code=start
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int preMax = nums[0], curMax = nums[0];
        int preMin = nums[0], curMin = nums[0];
        int sum = nums[0];
        // 求出正常数组的最大子序列和；再求出数组的最小子序列和，用数组的和减去最小的子序列和等于环形最大的值；比较两个最大值
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            preMax = Math.max(nums[i], nums[i] + preMax);
            curMax = Math.max(preMax, curMax);
            preMin = Math.min(nums[i], nums[i] + preMin);
            curMin = Math.min(preMin, curMin);
        }
        // 所有数都小于0 ，返回最大的数
        if (curMax < 0) {
            return curMax;
        }
        return Math.max(curMax, sum - curMin);
    }
}
// @lc code=end

