/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> lists = new ArrayList<>();
        int[][] dp = new int[rowIndex+1][rowIndex+1];
        dp[0][0] = 1;
        for (int i = 0; i <= rowIndex; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        for (int i = 0; i <= rowIndex; i++) {
            lists.add(dp[rowIndex][i]);
        }
        return lists;
    }
}
// @lc code=end

