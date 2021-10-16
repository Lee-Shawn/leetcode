/*
 * @lc app=leetcode.cn id=282 lang=java
 *
 * [282] 给表达式添加运算符
 */

// @lc code=start
class Solution {
    List<String> result = new ArrayList<>();
    String s;
    int n, t;

    public List<String> addOperators(String num, int target) {
        s = num;
        n = s.length();
        t = target;
        dfs(0, 0, 0, "");
        return result;
    }

    private void dfs(int u, long pre, long cur, String ss) {
        if (u == n) {
            if (cur == t) {
                result.add(ss);
                return;
            }
        }
        for (int i = u; i < n; i++) {
            // 前导0
            if (i != u && s.charAt(u) == '0') {
                break;
            }
            // 第k个值
            long next = Long.parseLong(s.substring(u, i + 1));
            if (u == 0) {
                dfs(i + 1, next, next, "" + next);
            } else {
                // 如果本次添加的 + 操作，且第 k 项的值是 next：那么直接使用 cur + next 来更新 cur，同时 next 作为下一次的 pre
                dfs(i + 1, next, cur + next, ss + "+" + next);
                // 如果本次添加的 - 操作，且第 k 项的值是 next：同理，那么直接使用 cur - next 来更新 cur，同时 -next 作为下一次的 pre
                dfs(i + 1, -next, cur - next, ss + "-" + next);
                // 如果本次添加的 * 操作，且第 k 项的值是 next：此时需要考虑运算符的优先级问题
                // 由于本次的 next 是与上一次的操作数 pre 执行乘法，而 cur 已经累加了 prev 的影响，因此需要先减去 pre，再加上 pre * next
                // 以此来更新 cur，同时 pre * next 也作为下一次的 pre
                long x = pre * next;
                dfs(i + 1, x, cur - pre + x, ss + "*" + next);
            }
        }
    }
}
// @lc code=end

