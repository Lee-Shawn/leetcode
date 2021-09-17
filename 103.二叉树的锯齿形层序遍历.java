/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) {
            return result;
        }
        // 树的层数
        int level = 0;
        deque.push(root);
        while (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = deque.size();
            if (level % 2 == 0) {
                while (size > 0) {
                    TreeNode node = deque.pop();
                    list.add(node.val);
                    if (node.left != null) {
                        deque.addLast(node.left);
                        stack.push(node.left);
                    }
                    if (node.right != null) {
                        deque.addLast(node.right);
                        stack.push(node.right);
                    }
                    size--;
                }
            } else {
                while (size > 0) {
                    TreeNode node = deque.pop();
                    TreeNode treeNode = stack.pop();
                    list.add(treeNode.val);
                    if (node.left != null) {
                        deque.addLast(node.left);
                    }
                    if (node.right != null) {
                        deque.addLast(node.right);
                    }
                    size--;
                }
            }
            level++;
            result.add(list);
        }
        return result;
    }
}
// @lc code=end

