/*
 * @lc app=leetcode.cn id=1436 lang=java
 *
 * [1436] 旅行终点站
 */

// @lc code=start
class Solution {
    public String destCity(List<List<String>> paths) {
        if (paths.size() == 1) {
            return paths.get(0).get(1);
        }
        Map<String, Integer> map = new HashMap<>(paths.size());
        for (List<String> s : paths) {
            map.put(s.get(0), 1);
        }
        for (List<String> s : paths) {
            if (!map.containsKey(s.get(1))) {
                return s.get(1);
            }
        }
        return null;
    }
}
// @lc code=end

