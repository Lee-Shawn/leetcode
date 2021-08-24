/*
 * @lc app=leetcode.cn id=1567 lang=java
 *
 * [1567] 乘积为正数的最长子数组长度
 */

// @lc code=start
class Solution {
    public int getMaxLen(int[] nums) {
        int max = 0;
        // 正乘积
        int positive = 0;
        // 负乘积
        int negative = 0;
        for (int n : nums) {
            if (n == 0) {
                positive = 0;
                negative = 0;
                continue;
            } else if (n > 0) {
                // 正数，直接加1；负数，如果前面没负数，还是0，前面有负数，加1
                positive += 1;
                negative = negative == 0 ? 0 : negative + 1;
            } else {
                //
                int temp = negative == 0 ? 0 : negative + 1;
                negative = positive + 1;
                positive = temp;
            }
            max = Math.max(max, positive);
        }
        return max;
    }
}
// @lc code=end

