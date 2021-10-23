/*
 * @lc app=leetcode.cn id=492 lang=java
 *
 * [492] 构造矩形
 */

// @lc code=start
class Solution {
    public int[] constructRectangle(int area) {
        int L, W;
        int[] result = new int[2];
        int sqrt = (int) Math.sqrt(area);
        for (int i = sqrt; i <= area; i++) {
            L = i;
            W = area / L;
            if (L * W == area && L >= W) {
                result[0] = L;
                result[1] = W;
                return result;
            }
        }
        return result;
    }
}
// @lc code=end

