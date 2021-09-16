/*
 * @lc app=leetcode.cn id=212 lang=java
 *
 * [212] 单词搜索 II
 */

// @lc code=start
class Solution {
    // 上下左右移动的方向
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<String> findWords(char[][] board, String[] words) {
        // 结果集
        List<String> resultList = new ArrayList<>();

        // 构建字典树
        TrieNode root = buildTrie(words);

        int m = board.length;
        int n = board[0].length;
        // 记录某个下标是否访问过
        boolean[][] visited = new boolean[m][n];
        // 记录沿途遍历到的元素
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // 从每个元素开始遍历
                dfs(resultList, result, board, i, j, root, root, visited);
            }
        }

        // 题目要求返回List
        return resultList;
    }

    private void dfs(List<String> resultList, StringBuilder result, char[][] board,
                     int i, int j, TrieNode root, TrieNode node, boolean[][] visited) {
        // 判断越界，或者访问过，或者不在字典树中，直接返回
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]
                || node == null || node.children[board[i][j] - 'a'] == null) {
            return;
        }

        // 记录当前字符
        result.append(board[i][j]);

        // 如果有结束字符，加入结果集中
        if (node.children[board[i][j] - 'a'].isEnd) {
            String word = result.toString();
            resultList.add(word);
            deleteWordFromTrie(root, word);
        }

        // 记录当前元素已访问
        visited[i][j] = true;

        // 按四个方向去遍历
        for (int[] dir : dirs) {
            dfs(resultList, result, board, i + dir[0], j + dir[1], root, node.children[board[i][j] - 'a'], visited);
        }

        // 还原状态
        visited[i][j] = false;
        result.deleteCharAt(result.length() - 1);
    }

    private void deleteWordFromTrie(TrieNode root, String word) {
        // 删除并没有那么好搞，需要先找到最后一个字符，从下往上删除
        delete(root, word, 0);
    }

    // 返回true表示可以把沿途节点删除，返回false表示不能删除沿途节点
    private boolean delete(TrieNode prev, String word, int i) {
        if (i == word.length() - 1) {
            // 如果后面还有单词则不能直接删除，比如dog和dogs是在一条链上，删除dog的时候不能把整个链删除了
            TrieNode curr = prev.children[word.charAt(i) - 'a'];
            if (hasChildren(curr)) {
                curr.isEnd = false;
                return false;
            } else {
                prev.children[word.charAt(i) - 'a'] = null;
                return true;
            }
        } else {
            // 如果后面的说可以删除，并且当前节点不是单词节点，并且没有其它子节点了，那么删除之，否则返回false
            // 比如删除dogs的时候不能把dog删除了
            // 比如同时存在dog和dig两个单词，删除dog的时候返回到d的时候，这个d是不能删除的
            if (delete(prev.children[word.charAt(i) - 'a'], word, i + 1)
                    && !prev.children[word.charAt(i) - 'a'].isEnd
                    && !hasChildren(prev.children[word.charAt(i) - 'a'])) {
                prev.children[word.charAt(i) - 'a'] = null;
                return true;
            }
            return false;
        }
    }

    private boolean hasChildren(TrieNode curr) {
        for (TrieNode child : curr.children) {
            if (child != null) {
                return true;
            }
        }
        return false;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            char[] arr = word.toCharArray();
            TrieNode curr = root;
            for (char c : arr) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isEnd = true;
        }
        return root;
    }

    class TrieNode {
        // 记录到这个节点是否是一个完整的单词
        boolean isEnd = false;
        // 孩子节点，题目说了都是小写字母，所以用数组，否则可以用HashMap替换
        TrieNode[] children = new TrieNode[26];
    }
}
// @lc code=end

