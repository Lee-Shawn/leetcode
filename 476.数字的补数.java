/*
 * @lc app=leetcode.cn id=476 lang=java
 *
 * [476] 数字的补数
 */

// @lc code=start
class Solution {
    public int findComplement(int num) {
        int bit = -1;
        int result = 0;
        // 找到最高位的1
        for (int i = 31; i >= 0; i--) {
            if (((num >> i) & 1) != 0) {
                bit = i;
                break;
            }
        }
        // 逐个取反
        for (int i = 0; i < bit; i++) {
            if (((num >> i) & 1) == 0) {
                result |= (1 << i);
            }
        }
        return result;
    }
}
// @lc code=end

