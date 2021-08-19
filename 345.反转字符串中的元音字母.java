/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 */

// @lc code=start
class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException("字符串不能为空！");
        }
        char[] c = s.toCharArray();
        int i = 0, j = s.length() - 1;
        char temp;
        while (i < j) {
            if (!(c[i] == 'A' || c[i] == 'E' || c[i] == 'I' || c[i] == 'O' || c[i] == 'U' ||
                    c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] == 'o' || c[i] == 'u')) {
                i++;
            }
            if (!(c[j] == 'A' || c[j] == 'E' || c[j] == 'I' || c[j] == 'O' || c[j] == 'U' ||
                    c[j] == 'a' || c[j] == 'e' || c[j] == 'i' || c[j] == 'o' || c[j] == 'u')) {
                j--;
            }
            if ((c[i] == 'A' || c[i] == 'E' || c[i] == 'I' || c[i] == 'O' || c[i] == 'U' ||
                    c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] == 'o' || c[i] == 'u') &&
                    (c[j] == 'A' || c[j] == 'E' || c[j] == 'I' || c[j] == 'O' || c[j] == 'U' ||
                            c[j] == 'a' || c[j] == 'e' || c[j] == 'i' || c[j] == 'o' || c[j] == 'u')) {
                temp = c[i];
                c[i] = c[j];
                c[j] = temp;
                i++;
                j--;
            }
        }
        return new String(c);
    }
}
// @lc code=end

