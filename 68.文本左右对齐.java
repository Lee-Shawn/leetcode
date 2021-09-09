/*
 * @lc app=leetcode.cn id=68 lang=java
 *
 * [68] 文本左右对齐
 */

// @lc code=start
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int length = words.length;
        int position = 0;
        while (true) {
            // 当前行第一个单词在words中的位置
            int curFirst = position;
            // 当前行单词长度
            int curLength = 0;
            // 循环确定当前行可以放入多少单词，每个单词之前至少有一个空格
            while (position < length && curLength + words[position].length() + position - curFirst <= maxWidth) {
                curLength += words[position++].length();
            }

            // 当前行是最后一行，单词左对齐，单词间只有一个空格，右侧补充空格
            if (position == length) {
                StringBuffer sb = join(words, curFirst, length, " ");
                // 最右侧空格数
                int space = maxWidth - sb.length();
                sb.append(blank(space));
                list.add(sb.toString());
                return list;
            }

            // 当前行单词数和空格数
            int numWord = position - curFirst;
            int numSpace = maxWidth - curLength;

            // 当前行只有一个单词：该单词左对齐，在行末填充剩余空格
            if (numWord == 1) {
                StringBuffer sb = new StringBuffer(words[curFirst]);
                sb.append(blank(numSpace));
                list.add(sb.toString());
                continue;
            }

            // 当前行不只一个单词
            int avgSpace = numSpace / (numWord - 1);
            int extraSpace = numSpace % (numWord - 1);
            StringBuffer sb = new StringBuffer();
            // 拼接额外加一个空格的单词
            sb.append(join(words, curFirst, curFirst + extraSpace + 1, blank(avgSpace + 1)));
            sb.append(blank(avgSpace));
            // 拼接其余单词
            sb.append(join(words, curFirst + extraSpace + 1, position, blank(avgSpace)));
            list.add(sb.toString());
        }
    }

    /**
     * 返回用 s 拼接 [curFirst, position) 范围内的 words 组成的字符串
     * @param words 数组
     * @param curFirst 当前行第一个单词在 words 中的位置
     * @param position 数组下标
     * @param s 字符串
     * @return 拼接的字符串
     */
    public StringBuffer join(String[] words, int curFirst, int position, String s) {
        StringBuffer sb = new StringBuffer(words[curFirst]);
        for (int i = curFirst + 1; i < position; i++) {
            sb.append(s);
            sb.append(words[i]);
        }
        return sb;
    }

    /**
     * blank 返回长度为 n 的由空格组成的字符串
     * @param n 空格数
     * @return 字符串
     */
    public String blank(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; ++i) {
            sb.append(' ');
        }
        return sb.toString();
    }
}
// @lc code=end

