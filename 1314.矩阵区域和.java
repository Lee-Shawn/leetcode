/*
 * @lc app=leetcode.cn id=1314 lang=java
 *
 * [1314] 矩阵区域和
 */

// @lc code=start
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 二维前缀和
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + mat[i-1][j-1];
            }
        }
        int[][] answer = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 二维前缀和：sum = P[i + K + 1][j + K + 1] - P[i - K][j + K + 1] - P[i + K + 1][j - K] + P[i - K][j - K]
                answer[i][j] = get(dp, m, n, i+k+1, j+k+1) - get(dp, m, n, i-k, j+k+1) -
                        get(dp, m, n, i+k+1, j-k) + get(dp, m, n, i-k, j-k);
            }
        }
        return answer;
    }

    public int get(int[][] dp, int m, int n, int x, int y) {
        x = Math.max(Math.min(x, m), 0);
        y = Math.max(Math.min(y, n), 0);
        return dp[x][y];
    }
}
// @lc code=end

