/*
 * @lc app=leetcode id=328 lang=java
 *
 * [328] Odd Even Linked List
 */

// @lc code=start
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }
        var even_head = new ListNode(777);        
        var odd_head = new ListNode(666);
        var even_node = even_head;
        var odd_node = odd_head;
        var node = head;
        int counter = 1;
        var prev_odd_node = node;
        while(node != null){
            if (counter % 2 == 0){
                even_node.next = node;
                even_node = even_node.next;
            }else{
                odd_node.next = node;
                prev_odd_node = odd_node;
                odd_node = odd_node.next;
            }
            node = node.next;
            counter++;
        }
        even_node.next = null;
        odd_node.next = null;
        // System.out.println(even_head);
        // System.out.println(odd_head);
        prev_odd_node.next.next = even_head.next;
        odd_head = odd_head.next;
        return odd_head;
    }

    static ListNode getTail(ListNode head) {
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

    public static void main(String[] args) {
        var head = array2list(new int[]{1, 2, 3, 4, 5});
        var result = new Solution().oddEvenList(head);
        System.out.println(result);
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
        return String.format("v:%d -> %s", val, next);
    }
}
