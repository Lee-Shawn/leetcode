/*
 * @lc app=leetcode.cn id=237 lang=java
 *
 * [237] 删除链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // 将后一个节点的值赋值给待删除的节点，然后删除后一个节点
        ListNode temp = node.next;
        node.val = temp.val;
        node.next = temp.next;
    }
}
// @lc code=end

