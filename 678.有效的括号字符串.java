/*
 * @lc app=leetcode.cn id=678 lang=java
 *
 * [678] 有效的括号字符串
 */

// @lc code=start
class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int min = 0, max = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                // 如果遇到左括号，则未匹配的左括号数量加 1
                min++;
                max++;
            } else if (c == ')') {
                // 如果遇到右括号，则需要有一个左括号和右括号匹配，因此未匹配的左括号数量减 1
                // 当最小值为 0 时，不应将最小值继续减少，以确保最小值非负
                // 当最大值变成负数时，说明没有左括号可以和右括号匹配
                min = Math.max(min - 1, 0);
                max--;
                if (max < 0) {
                    return false;
                }
            } else {
                // 如果遇到星号，由于星号可以看成左括号、右括号或空字符串，因此未匹配的左括号数量可能加 1、减 1 或不变
                min = Math.max(min - 1, 0);
                max++;
            }
        }
        return min == 0;
    }
}
// @lc code=end

