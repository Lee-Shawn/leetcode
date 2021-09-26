/*
 * @lc app=leetcode.cn id=371 lang=java
 *
 * [371] 两整数之和
 */

// @lc code=start
class Solution {
    public int getSum(int a, int b) {
        // a ^ b，算出的值不包括进位，(a & b) << 1，得到进位值
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}
// @lc code=end

