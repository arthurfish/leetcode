import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 */

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
        return String.format("%d -> %s", val, next);
    }

    public static void main(String[] args) {
        Solution.main(args);
    }
}

// @lc code=start

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Null detection
        if (lists == null) {
            return null;
        }
        boolean isAllListNull = true;
        for (var node : lists) {
            if (node != null) {
                isAllListNull = false;
            }
        }
        if (isAllListNull) {
            return null;
        }
        // End null detection
        Queue<ListNode> queue = new LinkedList<ListNode>();
        for (var head : lists) {
            queue.add(head);
        }
        while (queue.size() != 1) {
            var list1 = queue.poll();
            var list2 = queue.poll();
            queue.add(mergeTwoLists(list1, list2));
        }
        return queue.poll();
    }

    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            l1 = new ListNode(inf);
        }
        if( l2 == null){
            l2 = new ListNode(inf);
        }
        getTail(l1).next = new ListNode(inf);
        getTail(l2).next = new ListNode(inf);
        var out_head = new ListNode();
        var out_ptr = out_head;
        var node_iter_1 = l1;
        var node_iter_2 = l2;
        while (true) {
            if (node_iter_1.val == inf && node_iter_2.val == inf) {
                break;
            }
            if (node_iter_1.val < node_iter_2.val) {
                out_ptr.next = new ListNode(node_iter_1.val);
                node_iter_1 = node_iter_1.next;
            } else {
                out_ptr.next = new ListNode(node_iter_2.val);
                node_iter_2 = node_iter_2.next;
            }
            out_ptr = out_ptr.next;
        }
        return out_head.next;
    }

    public static void main(String[] args) {
        var test_arg = new ListNode[3];
        test_arg[0] = array2list(new int[] { 1, 4, 5 });
        test_arg[1] = array2list(new int[] { 1, 3, 4 });
        test_arg[2] = array2list(new int[] { 2, 6 });

        var result = new Solution().mergeKLists(test_arg);
        System.out.println(result);

        // var result = new Solution().mergeTwoLists(test_arg[0], test_arg[1]);
        // System.out.println(result);
    }

    int inf = Integer.MAX_VALUE;

    ListNode getTail(ListNode head) {
        if (head.next == null) {
            return head;
        } else {
            return getTail(head.next);
        }
    }

    static ListNode array2list(int[] arr) {
        var head = new ListNode();
        var node = head;
        for (var e : arr) {
            node.next = new ListNode();
            node.next.val = e;
            node = node.next;
        }
        return head.next;
    }
}
// @lc code=end
