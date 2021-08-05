/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int remainder = x % 10;
            int temp = result * 10 + remainder;
            // 如果溢出返回0
            if ((temp - remainder) / 10 != result) {
                return 0;
            }
            result = temp;
            x /= 10;
        }
        return result;
    }
}
// @lc code=end

