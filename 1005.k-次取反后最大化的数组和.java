/*
 * @lc app=leetcode.cn id=1005 lang=java
 *
 * [1005] K 次取反后最大化的数组和
 */

// @lc code=start
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        /*
         * 全大于0，k 为偶数
         * 全大于0，k 为奇数
         * 全小于0，k 大于 length
         * 全小于0，k 小于 length
         * 部分小于0
         */
        int n = nums.length;
        int mod = k % 2;
        int sum = 0;
        Arrays.sort(nums);
        if (nums[0] >= 0 && mod == 0) {
            for (int num : nums) {
                sum += num;
            }
            return sum;
        } else if (nums[0] >= 0 && mod == 1) {
            nums[0] = -nums[0];
        } else if (nums[n - 1] <= 0 && k > n) {
            // 数组元素全是负数，k 大于 n
            // n 个元素全部取反
            for (int i = 0; i < n; i++) {
                nums[i] = -nums[i];
            }
            // 超出 n 的部分，如果是奇数则最后一个元素取反
            if ((k - n) % 2 == 1) {
                nums[n - 1] = -nums[n - 1];
            }
        } else {
            // -4,-3,-1,2,5
            // 负数取反，k 还没结束，最大的负数取反
            int temp = 0;
            for (int i = 0; i < k; i++) {
                if (nums[i] <= 0) {
                    temp++;
                    nums[i] = -nums[i];
                } else {
                    // 最大的负数绝对值比最小的正数小
                    if (Math.abs(nums[temp - 1]) < nums[temp]) {
                        nums[temp - 1] = -nums[temp - 1];
                    } else {
                        nums[temp] = -nums[temp];
                    }
                }
            }
        }
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
// @lc code=end

