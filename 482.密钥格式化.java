/*
 * @lc app=leetcode.cn id=482 lang=java
 *
 * [482] 密钥格式化
 */

// @lc code=start
class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        // 从后往前遍历字符串，跳过-，添加到sb中，每隔k个字符添加一个-
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '-') {
                count++;
                sb.append(Character.toUpperCase(s.charAt(i)));
                if (count % k == 0) {
                    sb.append("-");
                }
            }
        }
        // 如果最后一个字符是-就删除
        if (sb.length() > 0 && sb.charAt(sb.length()-1) == '-') {
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

