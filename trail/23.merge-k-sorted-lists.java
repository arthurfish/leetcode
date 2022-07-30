package trail;

/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    @Override
    public String toString() {
        return String.format("v:%d -> %s", val, next);
    }
    public static void main(String[] args) {
        Solution.main(args);
    }
}

// @lc code=start

class Solution {
    int inf = Integer.MAX_VALUE;
    
    ListNode getTail(ListNode head) {
        if (head.next == null) {
            return head;
        } else {
            return getTail(head.next);
        }
    }
    static ListNode array2list(int[] arr){
        var head = new ListNode();
        var node = head;
        for(var e: arr){
            node.next = new ListNode();
            node.next.val = e;
            node = node.next;
        }
        return head.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        //Null detection
        if(lists == null){
            return null;
        }
        boolean isAllListNull = true;
        for(var node : lists){
            if(node != null){
                isAllListNull = false;
            }
        }
        if(isAllListNull){
            return null;
        }
        //End null detection
        for(var node : lists){
            if(node == null){
                continue;
            }
            getTail(node).next = new ListNode(inf);
        }
        var out_head = new ListNode(666);
        var out_ptr = out_head;
        while(true){
            // System.out.println(lists[0]);
            // System.out.println(lists[1]);
            // System.out.println(lists[2]);
            int minimum = inf;
            int min_pos = -1;
            for(int i = 0; i < lists.length; i++){
                if(lists[i] == null){
                    continue;
                }
                if(lists[i].val < minimum){
                    minimum = lists[i].val;
                    min_pos = i;
                }
            }

            if(minimum == inf){
                break;
            }
            
            out_ptr.next = new ListNode(minimum);
            out_ptr = out_ptr.next;

            lists[min_pos] = lists[min_pos].next;

        }
        return out_head.next;
    }
    public static void main(String[] args) {
        var test_arg = new ListNode[3];    
        test_arg[0] = array2list(new int[]{1, 4, 5});
        test_arg[1] = array2list(new int[]{1, 3, 4});
        test_arg[2] = array2list(new int[]{2, 6});
        
        var result = new Solution().mergeKLists(test_arg);
        // System.out.println(result);
    }
}
// @lc code=end

