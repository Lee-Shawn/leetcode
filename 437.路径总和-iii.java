/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int result = rootSum(root, targetSum);
        result += pathSum(root.left, targetSum);
        result += pathSum(root.right, targetSum);
        return result;
    }

    private int rootSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        int val = root.val;
        if (val == targetSum) {
            result++;
        }
        result += rootSum(root.left, targetSum - val);
        result += rootSum(root.right, targetSum - val);
        return result;
    }
}
// @lc code=end

