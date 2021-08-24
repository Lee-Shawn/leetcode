/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("数组为空");
        }
        int result = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            // 最大值和最小值乘以当前值比较，最小值为负数，当前值也为负数，值可能更大
            max = Math.max(Math.max(nums[i] * max, nums[i]), nums[i] * min);
            min = Math.min(Math.min(nums[i] * min, nums[i]), nums[i] * temp);
            result = Math.max(max, result);
        }
        return result;
    }
}
// @lc code=end

