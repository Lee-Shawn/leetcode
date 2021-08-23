/*
 * @lc app=leetcode.cn id=1646 lang=java
 *
 * [1646] 获取生成数组中的最大值
 */

// @lc code=start
class Solution {
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        int[] num = new int[n+1];
        num[0] = 0;
        num[1] = 1;
        int max = num[1];
        for (int i = 1; i <= n; i++) {
            if (2 * i >= 2 && 2 * i <= n) {
                num[2*i] = num[i];
                if (num[2*i] > max) {
                    max = num[2*i];
                }
            }
            if ((2 * i + 1) > 2 && (2 * i + 1) <= n) {
                num[2*i+1] = num[i] + num[i+1];
                if (num[2*i+1] > max) {
                    max = num[2*i+1];
                }
            }
        }
        return max;
    }
}
// @lc code=end

