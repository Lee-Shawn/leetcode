/*
 * @lc app=leetcode.cn id=273 lang=java
 *
 * [273] 整数转换英文表示
 */

// @lc code=start
class Solution {
    private static final String[] single = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] teen = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] ten = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] hundred = {"", "Hundred", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        int[] bit = new int[4];
        int j = 0;
        StringBuilder sb = new StringBuilder();
        // 将整数按每三位分割开存入数组
        for (int i = 1000000000; i >= 1; i /= 1000) {
            bit[j] = num / i;
            num %= i;
            j++;
        }
        for (int i = 0; i < 4; i++) {
            if (bit[i] != 0) {
                sb.append(conversion(bit[i]));
                if (i == 0) {
                    if (bit[1] == 0 && bit[2] == 0 && bit[3] == 0) {
                        sb.append(" ").append(hundred[4]);
                    } else {
                        sb.append(" ").append(hundred[4]).append(" ");
                    }
                } else if (i == 1) {
                    if (bit[2] == 0 && bit[3] == 0) {
                        sb.append(" ").append(hundred[3]);
                    } else {
                        sb.append(" ").append(hundred[3]).append(" ");
                    }
                } else if (i == 2) {
                    if (bit[3] == 0) {
                        sb.append(" ").append(hundred[2]);
                    } else {
                        sb.append(" ").append(hundred[2]).append(" ");
                    }
                }
            }
        }
        return sb.toString();
    }

    /**
     * 将三位数转换成英文
     * @param num 三位整数
     * @return 转换后的英文
     */
    private String conversion(int num) {
        int a, b, c;
        StringBuilder sb = new StringBuilder();
        a = num / 100;
        b = num / 10 % 10;
        c = num % 10;
        if (a != 0) {
            if (b == 0 && c == 0) {
                sb.append(single[a]).append(" ").append(hundred[1]);
            } else {
                sb.append(single[a]).append(" ").append(hundred[1]).append(" ");
            }
        }
        if (b > 1) {
            if (c != 0) {
                sb.append(ten[b]).append(" ");
            } else {
                sb.append(ten[b]);
            }
        } else if (b == 1) {
            sb.append(teen[c]);
        }
        if (b != 1) {
            sb.append(single[c]);
        }
        return sb.toString();
    }
}
// @lc code=end

