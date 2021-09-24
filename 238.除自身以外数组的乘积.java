/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        /*int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        right[n-1] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int j = n - 2; j >= 0; j--) {
            right[j] = right[j + 1] * nums[j + 1];
        }
        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }*/
        int left = 1, right = 1;
        // 數組初始化為1
        for (int i = 0; i < n; i++) {
            result[i] = 1;
        }
        // i 左邊的乘積
        for (int i = 0; i < n; i++) {
            result[i] *= left;
            left *= nums[i];
        }
        // i 右邊的乘積
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayProduct a = new ArrayProduct();
        int[] b = new int[]{1,2,3,4};
        int[] r = a.productExceptSelf(b);
        System.out.println(Arrays.toString(r));
    }
    }
}
// @lc code=end

