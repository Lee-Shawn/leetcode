/*
 * @lc app=leetcode.cn id=344 lang=java
 *
 * [344] 反转字符串
 */

// @lc code=start
class Solution {
    public void reverseString(char[] s) {
        char temp;
        for (int i = 0; i < s.length / 2; i++) {
            int j = s.length - 1 - i;
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}
// @lc code=end

