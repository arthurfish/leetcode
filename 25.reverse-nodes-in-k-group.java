import java.util.ArrayList;

/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
 */

// @lc code=start
class Solution {
    ListNode array2list(int[] arr){
        var head = new ListNode();
        var node = head;
        for(var e: arr){
            node.next = new ListNode();
            node.next.val = e;
            node = node.next;
        }
        return head.next;
    }
    public static void main(String[] args) {
        var head = new Solution().array2list(new int[]{1, 2, 3, 4, 5});
        var ans = new Solution().reverseKGroup(head, 2);
        System.out.println(ans);
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        var array_list = new ArrayList<ListNode>();
        for(var node = head; node != null; node = node.next){
            array_list.add(node);
        }
        for(int i = 0; i + k <= array_list.size(); i += k){
            for(int j = i; j <= (i + i + k - 1) / 2; j++) {
                // System.out.printf("i:%d, j:%d\n", i, j);
                // System.out.printf("will replace %d and %d.\n", array_list.get(j).val, array_list.get(i+k-1-(j-i)).val);
                var temp = array_list.get(j);
                array_list.set(j, array_list.get(i+k-1-(j-i)));
                array_list.set(i+k-1-(j-i), temp);
            }
        }
        array_list.add(null);
        for(int i = 0; i < array_list.size() - 1; i++){
            array_list.get(i).next = array_list.get(i+1);
        }
        return array_list.get(0);
    }
}
// @lc code=end

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    @Override
    public String toString() {
        return String.format("%d -> %s", val, next);
    }
}

