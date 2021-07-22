/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }
        // 双指针一前一后
        ListNode l = null;
        ListNode r = head;
        while (head != null) {
            // r往右移动
            r = r.next;
            // 将指针的next从指向后面转向指向前面一个节点
            head.next = l;
            // l往右移动
            l = head;
            // head往右移动
            head = r;
        }
        return l;
    }
}
// @lc code=end

