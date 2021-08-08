/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int mid = (m + n) / 2;
        int[] temp = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                temp[k++] = nums1[i++];
            } else {
                temp[k++] = nums2[j++];
            }
        }
        while (i < m && j == n) {
            temp[k++] = nums1[i++];
        }
        while (i == m && j < n) {
            temp[k++] = nums2[j++];
        }
        if ((m + n) % 2 == 1) {
            return temp[mid];
        } else if ((m + n) % 2 == 0) {
            return (temp[mid - 1] + temp[mid]) / 2.0;
        }
        return 0;
    }
}
// @lc code=end

