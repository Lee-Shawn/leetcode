/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // 排序之后，最左边的数大于0，就找不到了
            if (nums[i] > 0) {
                break;
            }
            // 两个数相同，存在重复的结果
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                // 三数之和大于0，移动右指针；小于0移动左指针；相同加入List
                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    List<Integer> three = new ArrayList<>(3);
                    three.add(nums[i]);
                    three.add(nums[j]);
                    three.add(nums[k]);
                    lists.add(three);
                    // 加入集合后，同时移动左右指针，可能还存在其他结果
                    j++;
                    k--;
                    // 两个数相同，存在重复的结果
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return lists;
    }
}
// @lc code=end

