/*
 * @lc app=leetcode.cn id=551 lang=java
 *
 * [551] 学生出勤记录 I
 */

// @lc code=start
class Solution {
    public boolean checkRecord(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException("字符串为空！");
        }
        char[] chars = s.toCharArray();
        int count = 0;
        if (s.length() == 1) {
            return true;
        } else if (s.length() == 2) {
            return s.charAt(0) != 'A' || s.charAt(1) != 'A';
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'A') {
                count++;
                if (count == 2) {
                    return false;
                }
            }
            if ((i + 2) < chars.length && (chars[i] == 'L' && chars[i + 1] == 'L' && chars[i + 2] == 'L')) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

