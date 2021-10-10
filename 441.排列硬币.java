/*
 * @lc app=leetcode.cn id=441 lang=java
 *
 * [441] 排列硬币
 */

// @lc code=start
class Solution {
    public int arrangeCoins(int n) {
        // 每一行的硬币
        int a = 1;
        // 完整阶梯总行数
        int result = 0;
        while (n > 0) {
            result++;
            n -= a;
            a++;
        }
        if (n == 0) {
            return result;
        } else {
            return result - 1;
        }
    }
}
// @lc code=end

