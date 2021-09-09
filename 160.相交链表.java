/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int m = 0;
        int n = 0;
        ListNode temp = headA;
        while (temp != null) {
            m++;
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        // 两个链表节点数的差值
        int diff = m - n;
        ListNode a = headA, b = headB;
        if (diff > 0) {
            while (diff-- > 0) {
                a = a.next;
            }
        } else if (diff < 0) {
            diff = n - m;
            while (diff -- > 0) {
                b = b.next;
            }
        }
        while (a != b) {
            a = a.next;
            b = b.next;
        }
        return a;
    }
}
// @lc code=end

