/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        long left = 0, right = num;
        while (left < right) {
            long mid = left + right + 1 >> 1;
            if (mid * mid <= num) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right * right == num;
    }
}
// @lc code=end

