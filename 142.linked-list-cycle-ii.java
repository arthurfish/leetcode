import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.HashMap;

/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
// class Solution {
//     public ListNode detectCycle(ListNode head) {
//         if (head == null) {
//             return null;
//         }
//         var node = head;
//         var set = new LinkedHashSet<ListNode>();
//         while (node != null) {
//             if (set.contains(node)) {
//                 return node;
//             }
//             set.add(node);
//             node = node.next;
//         }
//         return null;
//     }
// }

class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        var pf = head;
        var ps = head;
        do{
            ps = ps.next;
            pf = pf.next;
            if (pf == null) {
                return null;
            }
            pf = pf.next;
            if (pf == null) {
                return null;
            }
        } while (pf != ps);
        pf = head;
        while (pf != ps) {
            pf = pf.next;
            ps = ps.next;
        }
        return pf;
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
}
