/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        // haystack为空，needle不为空返回-1
        if ("".equals(haystack)) {
            if (!"".equals(needle)) {
                return -1;
            }
        }
        int hLen = haystack.length();
        int nLen = needle.length();
        int i = 0;
        while ((i + nLen) <= hLen) {
            // 截取子串和needle比较
            if (haystack.substring(i, i + nLen).equals(needle)) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
// @lc code=end

