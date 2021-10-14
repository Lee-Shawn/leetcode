/*
 * @lc app=leetcode.cn id=852 lang=java
 *
 * [852] 山脉数组的峰顶索引
 */

// @lc code=start
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int left = 1, right = n - 2;
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 右边的数都比arr[mid]大
            if (arr[mid] > arr[mid + 1]) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
// @lc code=end

