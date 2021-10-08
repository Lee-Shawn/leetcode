/*
 * @lc app=leetcode.cn id=187 lang=java
 *
 * [187] 重复的DNA序列
 */

// @lc code=start
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        int n = s.length();
        if (n <= 10) {
            return result;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n - 9; i++) {
            String sub = s.substring(i, i + 10);
            map.merge(sub, 1, Integer::sum);
        }
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() > 1) {
                result.add(e.getKey());
            }
        }
        return result;
    }
}
// @lc code=end

