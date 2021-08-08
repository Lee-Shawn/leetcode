/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            // 每次在第一个位置添加1
            row.add(0, 1);
            // 遍历每一行元素，跳过第一个和最后一个
            for (int j = 1; j < row.size() - 1; j++) {
                // 修改原来位置上的元素
                row.set(j, row.get(j) + row.get(j+1));
            }
            // 将row的元素复制添加到lists中
            lists.add(new ArrayList<>(row));
        }
        return lists;
    }
}
// @lc code=end

