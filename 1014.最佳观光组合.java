/*
 * @lc app=leetcode.cn id=1014 lang=java
 *
 * [1014] 最佳观光组合
 */

// @lc code=start
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int result = 0;
        // value[i] + i 的最大值
        int max = values[0];
        for (int j = 1; j < values.length; j++) {
            // values[j] - j 值固定，求出最大 max 即可
            result = Math.max(max + values[j] - j, result);
            max = Math.max(values[j] + j, max);
        }
        return result;
    }
}
// @lc code=end

