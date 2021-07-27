/*
 * @lc app=leetcode.cn id=278 lang=java
 *
 * [278] 第一个错误的版本
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n == 1) {
            return 1;
        }
        int left = 1;
        int right = n;
        while (left < right) {
            // (left+right)/2会越界
            // x + (y-x)/2 < y
            // 2x + y - x < 2y
            // x + y < 2y
            // x < y
            int first = left + (right - left) / 2;
            if (!isBadVersion(first)) {
                left = first + 1;
            } else {
                right = first;
            }
        }
        return left;
    }
}
// @lc code=end

