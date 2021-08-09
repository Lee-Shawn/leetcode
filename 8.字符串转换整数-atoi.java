/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        // 字符串转换成字符数组
        char[] chars = s.toCharArray();
        // 统计数字
        String result = "";
        // 转换后的整数
        int num = 0;
        long temp;
        // 符号的位数
        int symbol = 0;
        // 是否为正数
        boolean positive = true;
        // 标记是否是开头连续的空格
        boolean flag = true;
        int hasNum = 0;
        // 开头是英文字母或者.号返回0
        if (chars[0] == 46 || (chars[0] >= 65 && chars[0] <= 90) || (chars[0] >= 97 && chars[0] <= 122)) {
            return 0;
        }
        // s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
        for (int i = 0; i < chars.length; i++) {
            if (symbol >= 2) {
                break;
            }
            // 去除开头的空格
            if (flag && chars[i] == 32) {
                continue;
            }
            // 去除开头的0
            if (flag && chars[i] == '0') {
                // 开头的0后面不是数字直接返回0
                if ((i+1) < chars.length && (chars[i+1] < '0' || chars[i+1] > '9')) {
                    return 0;
                }
                continue;
            }
            // 后面再遇到空格直接截断
            flag = false;
            if (chars[i] == 32) {
                break;
            }
            // 标记是正数还是负数，符号位超过一位就返回0
            if (hasNum == 0 && chars[i] == '-') {
                positive = false;
                symbol++;
                continue;
            } else if (hasNum == 0 && chars[i] == '+'){
                symbol++;
                continue;
            } else if (chars[i] == 46 || (chars[i] >= 65 && chars[i] <= 90) || (chars[i] >= 97 && chars[i] <= 122)) {
                // 在中间位置遇到非数字字符直接截断
                break;
            }
            if (hasNum == 1 && (chars[i] == '-' || chars[i] == '+')) {
                break;
            }
            result = chars[i] + "";
            // 将每一位数字字符转换成整数
            int n = Integer.parseInt(result);
            temp = num * 10L + n;
            hasNum = 1;
            // 判断整数是否越界
            if (temp > 2147483647) {
                if (positive) {
                    return 2147483647;
                } else {
                    return -2147483648;
                }
            } else {
                num = (int) temp;
            }
        }
        if ("".equals(result)) {
            return 0;
        }
        // 判断大于0小于0
        if (positive) {
            return num;
        } else {
            return -num;
        }
    }
}
// @lc code=end

