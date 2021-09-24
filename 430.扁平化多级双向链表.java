/*
 * @lc app=leetcode.cn id=430 lang=java
 *
 * [430] 扁平化多级双向链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    private Node dfs(Node node) {
        Node current = node;
        // 最后一个节点
        Node last = null;
        while (current != null) {
            Node next = current.next;
            // 如果有子节点，先处理子节点
            if (current.child != null) {
                Node childLast = dfs(current.child);
                next = current.next;
                // 当前节点和子节点连接起来
                current.next = current.child;
                current.child.prev = current;
                // 如果 next 不为空，将 next 与 last 连起来
                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }
                // child 置空
                current.child = null;
                last = childLast;
            } else {
                last = current;
            }
            current = next;
        }
        return last;
    }
}
// @lc code=end

