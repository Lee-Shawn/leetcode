/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int length = 0;
        int max = length;
        for (int i = 0; i < chars.length; i++) {
            // 把字符数组放入map中，重复了就跳出循环向下移动一位
            Map<Character, Integer> map = new HashMap<>();
            for (int j = i; j < chars.length; j++) {
                if (map.containsKey(chars[j])) {
                    break;
                }
                map.put(chars[j], 1);
                length++;
            }
            max = Math.max(max, length);
            length = 0;
        }
        return max;
    }
}
// @lc code=end

