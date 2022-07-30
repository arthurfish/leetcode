import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
// Definition for a Node.

*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node node;
        var newHead = new Node(head.val);
        var newNode = newHead;
        var map = new HashMap<Node, Node>();
        for (node = head; node != null; node = node.next, newNode = newNode.next) {
            newNode.next = new Node(node.val);
            newNode.random = null;
            map.put(node, newNode.next);
            System.out.println(String.format("%d -> %d", node.val, newNode.next.val));
        }
        newHead = newHead.next;
        node = head;
        newNode = newHead;
        for (node = head, newNode = newHead; node != null
                && newNode != null; node = node.next, newNode = newNode.next) {
            if (node.random != null) {
                newNode.random = map.get(node.random);
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2, n1);
        Node n3 = new Node(3, n2);
        Node n4 = new Node(4, n3);
        Node n5 = new Node(5, n4);
        var head = n5;
        n5.random = n4;
        System.out.println(head);
        var ans = new Solution().copyRandomList(head);
        System.out.println(ans);
    }
}
// @lc code=end

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return String.format("[%s:(randomv:%d)] -> %s", val, (random == null) ? 0 : random.val, next);
    }
}