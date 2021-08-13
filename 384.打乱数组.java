/*
 * @lc app=leetcode.cn id=384 lang=java
 *
 * [384] 打乱数组
 */

// @lc code=start
class Solution {
    int[] nums;
    Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (nums == null || nums.length == 0) {
            return null;
        }
        // 克隆一个数组
        int[] clone = nums.clone();
        for (int i = 0; i < clone.length; i++) {
            int m = random.nextInt(i + 1);
            swap(clone, m, i);
        }
        return clone;
    }

    public void swap(int[] a,int m, int n) {
        if (m != n) {
            a[m] = a[m] + a[n];
            a[n] = a[m] - a[n];
            a[m] = a[m] - a[n];
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
// @lc code=end

