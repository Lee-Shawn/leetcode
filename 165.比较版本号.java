/*
 * @lc app=leetcode.cn id=165 lang=java
 *
 * [165] 比较版本号
 */

// @lc code=start
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0, j = 0;
        while (i < v1.length && j < v2.length) {
            int i1 = Integer.parseInt(v1[i]);
            int i2 = Integer.parseInt(v2[i]);
            if (i1 > i2) {
                return 1;
            } else if (i1 < i2) {
                return -1;
            }
            i++;
            j++;
        }
        while (i < v1.length) {
            int i1 = Integer.parseInt(v1[i]);
            int i2 = 0;
            if (i1 > i2) {
                return 1;
            } else if (i1 < i2) {
                return -1;
            }
            i++;
        }
        while (j < v2.length) {
            int i1 = 0;
            int i2 = Integer.parseInt(v2[j]);
            if (i1 > i2) {
                return 1;
            } else if (i1 < i2) {
                return -1;
            }
            j++;
        }
        return 0;
    }
}
// @lc code=end

