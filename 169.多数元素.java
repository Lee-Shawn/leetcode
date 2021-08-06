/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer num = map.get(nums[i]);
            if (num == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], num+1);
            }
        }
        int maxCount = 0;
        int maxValue = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            Integer key = entry.getKey();
            if (value > maxCount) {
                maxCount = value;
                maxValue = key;
            }
        }
        return maxValue;
    }
}
// @lc code=end

