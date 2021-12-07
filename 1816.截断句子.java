/*
 * @lc app=leetcode.cn id=1816 lang=java
 *
 * [1816] 截断句子
 */

// @lc code=start
class Solution {
    public String truncateSentence(String s, int k) {
        String[] split = s.split(" ");
        String result = "";
        for (int i = 0; i < k; i++) {
            if (i == k - 1) {
                result += split[i];
                break;
            }
            result += split[i] + " ";
        }
        return result;
    }
}
// @lc code=end

