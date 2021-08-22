/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        // 当前能跳的边界
        int end = 0;
        int maxPos = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 找到下一跳能跳的最远的
            maxPos = Math.max(maxPos, i + nums[i]);
            // 遇到边界就更新边界
            if (i == end) {
                end = maxPos;
                step++;
            }
        }
        return step;
    }
}
// @lc code=end

