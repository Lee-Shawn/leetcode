/*
 * @lc app=leetcode.cn id=447 lang=java
 *
 * [447] 回旋镖的数量
 */

// @lc code=start
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        for (int[] p : points) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] q : points) {
                // x * x + y * y
                int distance = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                // A(2,m) = m * (m - 1)
                Integer value = entry.getValue();
                result += value * (value - 1);
            }
        }
        return result;
    }
}
// @lc code=end

