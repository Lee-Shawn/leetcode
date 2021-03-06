/*
 * @lc app=leetcode.cn id=434 lang=java
 *
 * [434] 字符串中的单词数
 */

// @lc code=start
class Solution {
    public int countSegments(String s) {
        String[] split = s.split("\\s+");
        int count = 0;
        for (String str : split) {
            if (!"".equals(str)) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

