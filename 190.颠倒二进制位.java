/*
 * @lc app=leetcode.cn id=190 lang=java
 *
 * [190] 颠倒二进制位
 */

// @lc code=start
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // result先左移一位，把最后一位空出来用来存放n的最后一位
            result <<= 1;
            // n的最后一位加入result
            result |= n & 1;
            // n右移一位去掉最后一位数字
            n >>= 1;
        }
        return result;
    }
}
// @lc code=end

