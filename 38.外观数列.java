/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1);
        String seq = "";
        // 记录每一个字符
        char var = s.charAt(0);
        // 每个字符的个数
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == var) {
                count++;
            } else {
                seq += count + "";
                seq += var;
                // 记录下一个字符
                var = s.charAt(i);
                // 字符个数重置
                count = 1;
            }
        }
        // 只有一个字符的情况和最后一个字符的统计
        seq += count + "";
        seq += var;
        return seq;
    }
}
// @lc code=end

