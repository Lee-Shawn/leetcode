/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current = new ListNode();
        ListNode head = current;
        // 结果进位标志
        int carry = 0;
        // 两个链表都不为空
        while (l1 != null && l2 != null) {
            // 两个数相加的和没有进位，直接相加；和大于等于10，产生进位，当前节点值位0
            if (l1.val + l2.val + carry < 10) {
                current.val = l1.val + l2.val + carry;
                carry = 0;
            } else {
                current.val = l1.val + l2.val + carry - 10;
                carry = 1;
            }
            l1 = l1.next;
            l2 = l2.next;
            // 下一个节点位空，跳过循环，否则会多一个节点
            if (l1 == null || l2 == null) {
                break;
            }
            current.next = new ListNode();
            current = current.next;
        }
        // 只剩l1
        while (l1 != null) {
            current.next = new ListNode();
            current = current.next;
            if (l1.val + carry < 10) {
                current.val = l1.val + carry;
                carry = 0;
            } else {
                current.val = l1.val + carry - 10;
                carry = 1;
            }
            l1 = l1.next;
        }
        // 只剩l2
        while (l2 != null) {
            current.next = new ListNode();
            current = current.next;
            if (l2.val + carry < 10) {
                current.val = l2.val + carry;
                carry = 0;
            } else {
                current.val = l2.val + carry - 10;
                carry = 1;
            }
            l2 = l2.next;
        }
        // 最后一位和超过10，没有新建节点
        if (carry == 1) {
            current.next = new ListNode(1, null);
        }
        return head;
    }
}
// @lc code=end

