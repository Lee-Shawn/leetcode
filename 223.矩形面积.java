/*
 * @lc app=leetcode.cn id=223 lang=java
 *
 * [223] 矩形面积
 */

// @lc code=start
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int A = (ay2 - ay1) * (ax2 - ax1);
        int B = (by2 - by1) * (bx2 - bx1);
        // 水平线投影到x轴
        int areaX = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        // 铅垂线投影到y轴
        int areaY = Math.min(ay2, by2) - Math.max(ay1, by1);
        // 两条线的长度大于0，有重合部分
        int shadowArea = Math.max(areaX, 0) * Math.max(areaY, 0);
        return A + B - shadowArea;
    }
}
// @lc code=end

