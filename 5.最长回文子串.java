/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int begin = 0;
        int max = 1;
        // 状态数组，dp[i][j]表示s[i,j]是否是回文子串
        boolean[][] dp = new boolean[len][len];
        char[] c = s.toCharArray();
        for (int j = 1;j < len; j++) {
            for (int i = 0; i < j; i++) {
                // dp[i][j] = (c[i] == c[j] && dp[i+1][j-1])
                if (c[i] == c[j]) {
                    // 边界条件：(j-1) - (i+1) + 1 < 2 ==> j - i < 3
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        // 状态转移方程
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // dp[i][j]是回文子串且长度大于前面最大子串长度
                if (dp[i][j] && (j - i + 1 > max)) {
                    max = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + max);
    }
}
// @lc code=end

