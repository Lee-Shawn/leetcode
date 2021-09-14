/*
 * @lc app=leetcode.cn id=524 lang=java
 *
 * [524] 通过删除字母匹配到字典里最长单词
 */

// @lc code=start
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        // 字符串由长到短排序，长度相同按字符升序排序
        dictionary.sort((a, b) -> {
            if (a.length() != b.length()) {
                return b.length() - a.length();
            }
            return a.compareTo(b);
        });
        int n = s.length();
        for (String d : dictionary) {
            int m = d.length();
            int i = 0, j = 0;
            // 双指针比较s和字典中的字符串
            while (i < n && j < m) {
                if (s.charAt(i) == d.charAt(j)) {
                    j++;
                }
                i++;
            }
            // 匹配到了m个字符
            if (j == m) {
                return d;
            }
        }
        return "";
    }
}
// @lc code=end

