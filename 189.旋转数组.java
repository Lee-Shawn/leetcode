/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        // 临时数组存放移动后的数据
        int[] temp = new int[nums.length];
        int len = nums.length;
        int j = 0;
        // k超出数组长度
        int m = k % len;
        for (int i = len - m; i < len; i++) {
            temp[j++] = nums[i];
        }
        for (int i = 0; i < len - m; i++) {
            temp[j++] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }
}
// @lc code=end

