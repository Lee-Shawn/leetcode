/*
 * @lc app=leetcode.cn id=376 lang=java
 *
 * [376] 摆动序列
 */

// @lc code=start
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        // 前一个差值
        int pre = 0;
        // 当前差值
        int cur = 0;
        int result = 1;
        for (int i = 1; i < n; i++) {
            cur = nums[i] - nums[i - 1];
            if ((cur > 0 && pre <= 0) || (cur < 0 && pre >= 0)) {
                result++;
                pre = cur;
            }
        }
        return result;
    }
}
// @lc code=end

