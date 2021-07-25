/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    /**
     * 判断对称二叉树
     * @param left 左子节点
     * @param right 右子节点
     * @return 对称
     */
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        // 根结点的两个子节点必须要相同
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        // 左子节点的左子节点和右子节点的右子节点相同，左子节点的右子节点和右子节点的左子节点相同
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
// @lc code=end

