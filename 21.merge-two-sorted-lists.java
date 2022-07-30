/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (61.00%)
 * Likes:    13389
 * Dislikes: 1213
 * Total Accepted:    2.4M
 * Total Submissions: 3.9M
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list. The list should be made by
 * splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 *
 * Example 1:
 *
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 *
 * Example 2:
 *
 *
 * Input: list1 = [], list2 = []
 * Output: []
 *
 *
 * Example 3:
 *
 *
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 *
 *
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
    // public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    // getTail(list1).next = new ListNode(Integer.MAX_VALUE);
    // getTail(list2).next = new ListNode(Integer.MAX_VALUE - 1);
    // var origin_list1 = list1;
    // var origin_list2 = list2;
    // while (list1 != null && list2 != null) {
    // System.out.println(list1);
    // System.out.println(list2);
    // System.out.println("----");
    // if (list1.val >= list2.val) {
    // var origin_next = list2.next;
    // list2.next = list1;
    // list2 = origin_next;

    // } else {
    // var origin_next = list1.next;
    // list1.next = list2;
    // list1 = origin_next;

    // }
    // }
    // return (origin_list1.val <= origin_list2.val) ? origin_list1 : origin_list2;
    // }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 != null) {
            getTail(list1).next = new ListNode(Integer.MAX_VALUE);
        } else {
            list1 = new ListNode(Integer.MAX_VALUE);
        }
        if (list2 != null) {
            getTail(list2).next = new ListNode(Integer.MAX_VALUE - 1);
        } else {
            list2 = new ListNode(Integer.MAX_VALUE - 1);
        }
        var target = new ListNode(Integer.MIN_VALUE);
        var origin_target = target;
        var head1 = list1;
        var head2 = list2;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                target.next = head1;
                head1 = head1.next;
            } else {
                target.next = head2;
                head2 = head2.next;
            }
            target = target.next;
        }
        target = origin_target;
        while (target.next.val != Integer.MAX_VALUE - 1) {
            target = target.next;
        }
        target.next = null;
        return origin_target.next;
    }

    public static void main(String[] args) {
        var list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(5))));
        var list2 = new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(9))));
        System.out.println(new Solution().mergeTwoLists(list1, list2));

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