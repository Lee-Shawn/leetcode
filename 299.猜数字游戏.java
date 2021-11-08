/*
 * @lc app=leetcode.cn id=299 lang=java
 *
 * [299] 猜数字游戏
 */

// @lc code=start
class Solution {
    public String getHint(String secret, String guess) {
        int a = 0, b = 0;
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == g[i]) {
                a++;
                s[i] = 'a';
                g[i] = 'b';
            }
        }
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < g.length; j++) {
                if (s[i] == g[j]) {
                    b++;
                    g[j] = ' ';
                    break;
                }
            }
        }
        return a + "A" + b + "B";
    }
}
// @lc code=end

