/*
 * @lc app=leetcode.cn id=725 lang=java
 *
 * [725] 分隔链表
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        if (head == null) {
            return new ListNode[k];
        }

        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        temp = head;
        ListNode[] result = new ListNode[k];
        if (length < k) {
            for (int i = 0; i < length; i++) {
                result[i] = new ListNode(temp.val);
                temp = temp.next;
            }
            return result;
        }

        // 每段链表的长度
        int m = length / k;
        int n = length % k;
        int len;
        for (int i = 0; i < k; i++) {
            if (n > 0) {
                len = m + 1;
                n--;
            } else {
                len = m;
            }
            ListNode h = head;
            ListNode tail = head;
            for (int j = 1; j < len; j++) {
                tail = tail.next;
            }
            head = tail.next;
            tail.next = null;
            result[i] = h;
        }

        return result;
    }
}
// @lc code=end

