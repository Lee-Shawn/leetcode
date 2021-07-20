/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int count = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            // 如果最后一位不是9，直接加一返回
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else {
                // 如果是9，将这一位置成0，并统计置0的位数
                digits[i] = 0;
                count++;
            }
        }
        // 如果所有位都置0，数组长度加1，第一位设位1；否则将置0的前面一位加一
        if (count == digits.length) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            return newDigits;
        } else {
            digits[digits.length - 1 - count]++;
        }
        return digits;
    }
}
// @lc code=end

