import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 */

// @lc code=start
class Solution {

    ListNode getTail(ListNode head) {
        if (head.next == null) {
            return head;
        } else {
            return getTail(head.next);
        }
    }

    // public ListNode reverseBetween(ListNode head, int left, int right) {
    //     left++;
    //     right++;
    //     head = new ListNode(666, head);
    //     getTail(head).next = new ListNode(777);
    //     var before_left_node = head;
    //     var after_right_node = head;
    //     var left_node = head;
    //     var right_node = head;
    //     var node = head;
    //     var count = 0;
    //     ListNode cache = null;
    //     while (node != null) {
    //         count++;
    //         if (count == left - 1) {
    //             before_left_node = node;
    //             left_node = before_left_node.next;
    //         }
    //         if (count == right) {
    //             after_right_node = node.next;
    //             right_node = node;
    //             before_left_node.next = right_node;
    //             left_node.next = after_right_node;
    //             break;
    //         }
    //         if (left <= count && count <= right) {
    //             cache = node.next;
    //             node.next.next = node;
    //         } else {
    //             cache = null;
    //         }
    //         if (cache != null) {
    //             node = cache;
    //             System.out.println("#");
    //         } else {
    //             System.out.println("*");
    //             node = node.next;
    //         }
    //     }
    //     return head;
    // }
    // public ListNode reverseBetween(ListNode head, int left, int right) {
    //     if (head == null) {
    //         return null;
    //     }
    //     head = new ListNode(666, head);
    //     getTail(head).next = new ListNode(777);
    //     left += 1;
    //     right += 1;
    //     ListNode node = head;
    //     var before_left_node = node;
    //     var left_node = node;
    //     var right_node = node;
    //     var after_right_node = node;
    //     var count = 1;
    //     while (node != null) {
    //         if (count == left - 1) {
    //             before_left_node = node;
    //             left_node = node.next;
    //         }
    //         if (count == right) {
    //             right_node = node;
    //             after_right_node = node.next;
    //         }
    //         node = node.next;
    //         count++;
    //     }

    //     node = left_node;
    //     right_node.next = null;
    //     var assist_stack = new LinkedList<ListNode>();
    //     while (node != null) {
    //         assist_stack.push(node);
    //         var cache = node.next;
    //         node.next = null;
    //         node = cache;
    //     }
    //     System.out.println(assist_stack);
    //     var previous_node = new ListNode(888);
    //     var origin_previous_node = previous_node;
    //     while (assist_stack.size() != 0) {
    //         var top = assist_stack.pop();
    //         previous_node.next = top;
    //         previous_node = top;
    //     }
    //     origin_previous_node = origin_previous_node.next;
    //     before_left_node.next = origin_previous_node;
    //     getTail(origin_previous_node).next = after_right_node;

    //     head = head.next;
    //     node = head;
    //     while (node.next.val != 777) {
    //         node = node.next;
    //     }
    //     node.next = null;
    //     return head;

    // }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        var count = 1;
        var node = head;
        while (node != null) {
            if (count == left) {
                var next_cache = node.next.next;
                node.next.next = node;
                node = 
            }
        }
    }

    // ListNode reverseHelper(int index, ListNode head, int left, int right) {
    //     if (index < left) {
    //         var result = reverseHelper(index + 1, head.next, left, right);
    //         head.next = result;
    //         return head;
    //     }
    //     if (left <= index && index <= right) {
    //         var result = reverseHelper(index + 1, head.next, left, right);
    //         var tail = getTail(result);
    //         tail.next = head;
    //         return result;
    //     }
    //     if (right < index) {
    //         return head;
    //     }
    //     return null;
    // }
    public static void main(String[] args) {
        ListNode[] list = new ListNode[5];
        list[4] = new ListNode(5);
        list[3] = new ListNode(4, list[4]);
        list[2] = new ListNode(3, list[3]);
        list[1] = new ListNode(2, list[2]);
        list[0] = new ListNode(1, list[1]);

        System.out.println(list[0]);
        var result = new Solution().reverseBetween(list[0], 2, 4);
        System.out.println(result);

    }
}
// @lc code=end
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("v:%d -> %s", val, next);
    }
}

