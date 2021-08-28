/*
 * @lc app=leetcode.cn id=413 lang=java
 *
 * [413] 等差数列划分
 */

// @lc code=start
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        int count = 0;
        int len = 2;
        // 初试差
        int initDiff = nums[1] - nums[0];
        for (int i = 2; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff == initDiff) {
                len++;
            } else {
                count += (len - 1) * (len - 2) / 2;
                // 重置 len
                len = 2;
                // 当前差设为初试差
                initDiff = diff;
            }
        }
        count += (len - 1) * (len -2 ) / 2;
        return count;
    }
}
// @lc code=end

