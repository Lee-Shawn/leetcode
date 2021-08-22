/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        // 能达到的最远距离
        int maxJump = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果能达到当前位置，并且当前位置加跳跃数大于最远位置
            if (maxJump >= i && (i+nums[i]) > maxJump) {
                // 更新最远位置
                maxJump = i + nums[i];
            }
        }
        return maxJump >= nums.length - 1;
    }
}
// @lc code=end

