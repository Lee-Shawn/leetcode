/*
 * @lc app=leetcode.cn id=1480 lang=java
 *
 * [1480] 一维数组的动态和
 */

// @lc code=start
class Solution {
    public int[] runningSum(int[] nums) {
        int[] dynamic = new int[nums.length];
        dynamic[0] = nums[0];
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dynamic[i] = nums[i] + pre;
            pre = dynamic[i];
        }
        return dynamic;
    }
}
// @lc code=end

