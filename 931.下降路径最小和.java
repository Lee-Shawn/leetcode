/*
 * @lc app=leetcode.cn id=931 lang=java
 *
 * [931] 下降路径最小和
 */

// @lc code=start
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
            System.out.print("dp[0]["+i+"]=" + dp[0][i] + ",");
        }
        System.out.println();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(matrix[i][0] + dp[i - 1][j], matrix[i][0] + dp[i - 1][j + 1]);
                } else if (j == n - 1) {
                    dp[i][j] = Math.min(matrix[i][n - 1] + dp[i-1][j - 1], matrix[i][n - 1] +dp[i-1][j]);
                } else {
                    dp[i][j] = Math.min(Math.min(matrix[i][j] + dp[i-1][j - 1], matrix[i][j] + dp[i-1][j]),
                            matrix[i][j] + dp[i-1][j + 1]);
                }
                System.out.print("dp["+i+"]["+j+"]=" + dp[i][j] + ",");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            if (dp[n -1][i] < min) {
                min = dp[n - 1][i];
            }
        }
        return min;
    }
}
// @lc code=end

