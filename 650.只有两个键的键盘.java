/*
 * @lc app=leetcode.cn id=650 lang=java
 *
 * [650] 只有两个键的键盘
 */

// @lc code=start
class Solution {
    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        // f(10) = 2 + f(5)
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return i + minSteps(n / i);
            }
        }
        // 质数只能由1复制
        return n;
    }
}
// @lc code=end

