/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (prime[i]) {
                continue;
            }
            count++;
            for (int j = i; j < n; j+=i) {
                prime[j] = true;
            }
        }
        return count;
    }
}
// @lc code=end

