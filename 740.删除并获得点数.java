/*
 * @lc app=leetcode.cn id=740 lang=java
 *
 * [740] 删除并获得点数
 */

// @lc code=start
class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // 排序，为了找到最大值
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        // 建立一个数组，以nums数组的值做下标
        int[] count = new int[max + 1];
        for (int n : nums) {
            count[n]++;
        }
        // 状态数组
        int[] dp = new int[count.length];
        dp[1] = count[1];
        // 相邻位置不能同时取
        for (int i = 2; i < count.length; i++) {
            dp[i] = Math.max(dp[i-2] + count[i] * i, dp[i-1]);
        }
        return dp[max];
    }
}
// @lc code=end

