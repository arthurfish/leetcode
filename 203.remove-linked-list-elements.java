/*
 * @lc app=leetcode id=203 lang=java
 *
 * [203] Remove Linked List Elements
 */

// @lc code=start
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        var list_head = new ListNode(666, head);
        var previous_node = list_head;
        for (var node = head; node != null; node = node.next) {
            if(node.val == val){
                previous_node.next = node.next;
            }else{
                previous_node = node;
            }
        }
        return list_head.next;
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
}
