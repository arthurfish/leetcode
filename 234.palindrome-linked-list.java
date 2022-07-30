
/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
 */

// @lc code=start
class Solution {
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

    public boolean isPalindrome(ListNode head) {
        int length = 0;
        var node = head;
        for (node = head; node.next != null; node = node.next) {
            length++;
        }
        length++;
        var tail_node = node;
        if (length == 0) {
         
           return false;
        }
        if(length == 1){
            return true;
        }
        if (length == 2){
            if(head.val == head.next.val){
                return true;
            }else{
                return false;
            }
        }
        node = head;
        for (int i = 0; i < length / 2 - 1; i++) {
            node = node.next;
        }
        var before_half_pointer = node;
        // System.out.println("bhp.v:" + before_half_pointer.val);
        var next_cache = before_half_pointer.next.next;
        var next_next_cache = next_cache.next;
        for (node = before_half_pointer.next; node != null;) {
            // System.out.println("n.v: " + node.val);
            if (next_cache != null) {
                next_next_cache = next_cache.next;
                next_cache.next = node;
            }

            node = next_cache;
            next_cache = next_next_cache;
            if (next_next_cache != null)
                next_next_cache = next_next_cache.next;

        }
        before_half_pointer.next.next = null;
        before_half_pointer.next = tail_node;
        // System.out.println(head);

        node = head;
        for (int i = 0; i < length / 2; i++, node = node.next)
            ;
        // System.out.println(node.val);
        var p2_origin = node;
        ListNode p1, p2;
        for (p1 = head, p2 = p2_origin; p2 != null && p1.val == p2.val; p1 = p1.next, p2 = p2.next){
            // System.out.println("p1.v: " + p1.val);
            // System.out.println("p2.v: " + p2.val);
        }
        if (p1 == p2_origin) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        var head = array2list(new int[] {1, 2, 1});
        var result = new Solution().isPalindrome(head);
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
