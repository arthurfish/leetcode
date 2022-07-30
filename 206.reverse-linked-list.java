/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 */

// @lc code=start

class Solution {
    ListNode getTail(ListNode head) {
        if (head.next == null) {
            return head;
        }
        return getTail(head.next);
    }
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        var head2 = reverseList(head.next);
        var tail = getTail(head2);
        tail.next = head;
        head.next = null;
        return head2;
    }

    public static void main(String[] args) {
        var a = new ListNode(5, null);
        var b = new ListNode(4, a);
        var c = new ListNode(3, b);
        var d = new ListNode(2, c);
        var e = new ListNode(1, d);
        System.out.println(e);
        var f = new Solution().reverseList(e);
        System.out.println(f);

    }
}
// @lc code=end

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("v:%d -> %s", val, next);
    }
}

