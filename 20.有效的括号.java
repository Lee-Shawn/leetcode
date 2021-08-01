/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        // 长度为单数不符合
        if (s.length() % 2 == 1) {
            return false;
        }
        // 第一个字符为右括号不符合
        if (chars[0] == '}' || chars[0] == ']' || chars[0] == ')') {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        // 左括号加入栈，右括号就弹出栈中一个字符进行比较
        for (char c : chars) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}') {
                if (stack.empty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop != '{') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.empty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop != '[') {
                    return false;
                }
            } else if (c == ')') {
                if (stack.empty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop != '(') {
                    return false;
                }
            } else {
                return false;
            }
        }
        // 栈中的字符全部弹出为true，否则为false
        return stack.empty();
    }
}
// @lc code=end

