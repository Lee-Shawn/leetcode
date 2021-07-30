/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start
class MinStack {
    ListNode head = new ListNode(Integer.MAX_VALUE, Integer.MAX_VALUE, null);
    ListNode top;
    ListNode tail;

    /** initialize your data structure here. */
    public MinStack() {
        top = head;
        tail = head;
    }
    
    public void push(int val) {
        ListNode stack = new ListNode(val, val, null);
        if (empty()) {
            head.next = stack;
            top = stack;
            tail = stack;
            stack.min = val;
        } else {
            stack.min = Math.min(val, top.min);
            stack.next = top;
            head.next = stack;
            top = stack;
        }
    }
    
    public void pop() {
        if (empty()) {
            throw new RuntimeException();
        }
        head = head.next;
        top = head.next;
    }
    
    public int top() {
        return head.next.data;
    }
    
    public int getMin() {
        return head.next.min;
    }

    public boolean empty() {
        return head.next == null;
    }
}

class ListNode {
    int data;
    int min;
    ListNode next;

    public ListNode(int data, int min, ListNode next) {
        this.data = data;
        this.min = min;
        this.next = next;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

