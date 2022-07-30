import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
 *
 * https://leetcode.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (48.51%)
 * Likes:    3699
 * Dislikes: 503
 * Total Accepted:    353.9K
 * Total Submissions: 729.4K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * Given the head of a linked list and a value x, partition it such that all
 * nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 *
 *
 * Example 2:
 *
 *
 * Input: head = [2,1], x = 2
 * Output: [1,2]
 *
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in the list is in the range [0, 200].
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 *
 *
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
// class OldSolution {
//     LinkedList<Integer> toLinkedList(ListNode head) {
//         LinkedList<Integer> list = new LinkedList<>();
//         if (head == null) {
//             return list;
//         }
//         while (head != null) {
//             list.push(head.val);
//             head = head.next;
//         }
//         Collections.reverse(list);
//         return list;
//     }

//     ListNode toNodeList(LinkedList<Integer> list) {
//         if (list.size() == 0) {
//             return null;
//         }
//         var head = new ListNode();
//         var origin_head = head;
//         while (list.size() != 0) {
//             head.next = new ListNode(list.pop(), null);
//             head = head.next;
//         }
//         return origin_head.next;

//     }

//     public ListNode partition(ListNode head, int x) {
//         var list = toLinkedList(head);
//         var left = new LinkedList<Integer>(list.stream().filter(a -> a < x).toList());
//         var right = new LinkedList<Integer>(list.stream().filter(a -> a >= x).toList());

//         left.addAll(right);
//         return toNodeList(new LinkedList<Integer>(left));
//     }

//     public static void main(String[] args) {
//         var list = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
//         var a = new Solution().partition(list, 3);
//         System.out.println(a);
//     }
// }

class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        var left = new ListNode(666);
        var right = new ListNode(777);
        var origin_left = left;
        var orgin_right = right;
        while (head != null) {
            if (head.val < x) {
                left.next = new ListNode(head.val);
                left = left.next;
            } else {
                right.next = new ListNode(head.val);
                right = right.next;
            }
            head = head.next;
        }
        getTail(origin_left).next = orgin_right.next;
        return origin_left.next;
    }

    ListNode getTail(ListNode head) {
        if (head.next == null) {
            return head;
        } else {
            return getTail(head.next);
        }
    }

    public static void main(String[] args) {
        var list = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        var a = new Solution().partition(list, 3);
        System.out.println(a);
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

