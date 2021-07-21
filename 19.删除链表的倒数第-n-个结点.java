/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 双指针一次遍历
        ListNode l = head;
        ListNode r = head;
        // 删除节点
        ListNode delNode;
        int length = 1;
        // r指针先移动n个位置
        while (r.next != null) {
            length++;
            r = r.next;
            if (length == n + 1) {
                break;
            }
        }
        // 然后两个指针同时移动，r指针移动到最后时，l指针的下一个节点就是待删除节点
        while (r.next != null) {
            l = l.next;
            r = r.next;
            length++;
        }
        // n大于链表长度，不删除
        if (length < n) {
            return head;
        } else if (length == n) {
            // 删除第一个节点
            head = head.next;
            return head;
        }
        // 只有一个节点
        if (head.next == null) {
            return null;
        }
        // 删除节点
        delNode = l.next;
        l.next = delNode.next;
        return head;
    }
}
// @lc code=end

