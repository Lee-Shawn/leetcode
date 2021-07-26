/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        // 队列存放结点
        Queue<TreeNode> queue = new LinkedList<>();
        // 存放每一层结点的集合
        List<List<Integer>> lists = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 每一层结点的个数
            int nodeNum = queue.size();
            // 存放每一层结点
            List<Integer> node = new ArrayList<>();
            // 遍历每一层的结点
            while (nodeNum > 0) {
                // 出队遍历结点
                TreeNode treeNode = queue.remove();
                // 左右子树入队
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
                // 出队结点值放入集合
                node.add(treeNode.val);
                nodeNum--;
            }
            // 把每一层的结点集合放入集合
            lists.add(node);
        }
        return lists;
    }
}
// @lc code=end

