import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */

// @lc code=start
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        var set = new HashSet<ListNode>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;

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

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("v:%d -> %s", val, next);
    }
}

