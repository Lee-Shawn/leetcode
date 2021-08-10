/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        // 把数组第一个元素当作初始的公共前缀
        String result = strs[0];
        if ("".equals(result)) {
            return "";
        }
        // 第一个元素和第二个元素比较，得到的结果再跟后面的比较
        for (int i = 1; i < strs.length; i++) {
            String temp = "";
            // 
            int length = Math.min(result.length(), strs[i].length());
            // 匹配每个字符
            for (int j = 1; j <= length; j++){
                if (!result.substring(0, j).equals(strs[i].substring(0, j))) {
                    break;
                }
                temp = result.substring(0, j);
            }
            // 每次比较后的结果作为新的公共前缀
            result = temp;
            if ("".equals(result)) {
                return "";
            }
        }
        return result;
    }
}
// @lc code=end

