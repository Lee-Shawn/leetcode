/*
 * @lc app=leetcode.cn id=405 lang=java
 *
 * [405] 数字转换为十六进制数
 */

// @lc code=start
class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        long n = num;
        StringBuilder sb = new StringBuilder();
        if (n < 0) {
            n = (long) (Math.pow(2, 32) + n);
        }
        while (n != 0) {
            long m = n % 16;
            char c = (char) (m + '0');
            if (m >= 10) {
                c = (char) (m - 10 + 'a');
            }
            sb.append(c);
            n /= 16;
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

