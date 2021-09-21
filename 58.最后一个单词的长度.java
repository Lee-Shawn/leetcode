/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        char[] c = s.toCharArray();
        int length = 0;
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] == ' ' && length == 0) {
                continue;
            } else if (c[i] == ' ' && length > 0) {
                break;
            }
            if (c[i] != ' ') {
                length++;
            }
        }

        return length;
    }
}
// @lc code=end

