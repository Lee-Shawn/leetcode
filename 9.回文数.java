/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        } else if (x < 0) {
            return false;
        }
        int newX = 0;
        int n = x;
        while (x != 0) {
            int temp = x % 10;
            newX = newX * 10 + temp;
            x /= 10;
        }
        return newX == n;
    }
}
// @lc code=end

