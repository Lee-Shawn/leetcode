/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        // 数组长度为0或者1，直接i返回原数组长度
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        // 记录去重后的位置
        int count = 0;
        // 第一个数
        int a = nums[count];
        for (int i = 1; i < nums.length; i++) {
            // 如果两个数相同，就往后继续寻找
            if (nums[i] == a) {
                continue;
            }
            // 下一个不重复数的新位置
            count++;
            // 把不重复的数往前移动
            nums[count] = nums[i];
            // 指向下一个不重复的数
            a = nums[count];
        }
        return count+1;
    }
}
// @lc code=end

