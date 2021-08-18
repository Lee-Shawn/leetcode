/*
 * @lc app=leetcode.cn id=552 lang=java
 *
 * [552] 学生出勤记录 II
 */

// @lc code=start
class Solution {
    public int checkRecord(int n) {
        int MOD = 1000000007;
        // 状态数组
        int[][][] dp = new int[n + 1][2][3];
        // 边界
        dp[0][0][0] = 1;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            // P结尾
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k <= 2; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % MOD;
                }
            }
            // A结尾
            for (int k = 0; k <= 2; k++) {
                dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][k]) % MOD;
            }
            // L结尾
            for (int j = 0; j <= 1; j++) {
                for (int k = 1; k <= 2; k++) {
                    dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % MOD;
                }
            }
        }
        for (int j = 0; j <= 1; j++) {
            for (int k = 0; k <= 2; k++) {
                sum = (sum + dp[n][j][k]) % MOD;
            }
        }
        return sum;
    }
}
// @lc code=end

