/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m+n];
        int i = 0;
        int j = 0;
        int k = 0;
        // 两个数组排好序放入临时数组，再复制到num1中
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                temp[k] = nums1[i];
                k++;
                i++;
            } else {
                temp[k] = nums2[j];
                k++;
                j++;
            }
        }
        while (i < m && j == n) {
            temp[k] = nums1[i];
            k++;
            i++;
        }
        while (i == m && j < n) {
            temp[k] = nums2[j];
            k++;
            j++;
        }
        for (int p = 0; p < temp.length; p++) {
            nums1[p] = temp[p];
        }
    }
}
// @lc code=end

