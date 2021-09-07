/*
 * @lc app=leetcode.cn id=1221 lang=java
 *
 * [1221] 分割平衡字符串
 */

// @lc code=start
class Solution {
    public int balancedStringSplit(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        int L = 0, R = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                L++;
            } else {
                R++;
            }
            if (L == R) {
                result++;
                L = R = 0;
            }
        }
        return result;
    }
}
// @lc code=end

