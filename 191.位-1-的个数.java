/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            // 无符号n右移i位（高位补0）和1相与
            if (((n >>> i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

