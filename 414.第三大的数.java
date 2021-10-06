/*
 * @lc app=leetcode.cn id=414 lang=java
 *
 * [414] 第三大的数
 */

// @lc code=start
class Solution {
    public int thirdMax(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return nums[1];
        }
        int count = 1;
        for (int i = n - 1; i >= 1; i--) {
            if (nums[i - 1] != nums[i]) {
                count++;
                if (count == 3) {
                    return nums[i - 1];
                }
            }
        }
        return nums[n - 1];
    }
}
// @lc code=end

