/*
 * @lc app=leetcode.cn id=461 lang=java
 *
 * [461] 汉明距离
 */

// @lc code=start
class Solution {
    public int hammingDistance(int x, int y) {
        // 先异或
        int z = x ^ y;
        // return Integer.bitCount(z);
        int count = 0;
        // 再统计1的位数
        for (int i = 0; i < 32; i++) {
            if (((z >>> i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

