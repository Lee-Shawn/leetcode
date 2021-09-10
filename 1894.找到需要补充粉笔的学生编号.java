/*
 * @lc app=leetcode.cn id=1894 lang=java
 *
 * [1894] 找到需要补充粉笔的学生编号
 */

// @lc code=start
class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        int i = 0;
        long sum = 0;
        for (int c : chalk) {
            sum += c;
        }
        // 应对超出int范围的大数
        // k %= sum,k = (long) k % sum;
        k %= sum;
        while (k >= chalk[i]) {
            k -= chalk[i];
            i = (i + 1) % n;
        }
        return i;
    }
}
// @lc code=end

