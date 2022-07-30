/*
 * @lc app=leetcode id=641 lang=java
 *
 * [641] Design Circular Deque
 */

// @lc code=start
class MyCircularDeque {
    Node head = new Node();
    Node tail = new Node();
    int size = 0;
    int max_size = 0;

    public MyCircularDeque(int k) {
        head.n = tail;
        tail.p = head;
        max_size = k;
    }

    public boolean insertFront(int value) {
        if (size == max_size) {
            return false;
        }
        var node = new Node();
        node.v = value;
        node.p = head;
        node.n = head.n;
        head.n.p = node;
        head.n = node;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (size == max_size) {
            return false;
        }
        var node = new Node();
        node.v = value;
        node.p = tail.p;
        node.n = tail;
        tail.p.n = node;
        tail.p = node;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }
        if (head.n.n != null) {
            head.n.n.p = head;
        }
        head.n = head.n.n;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }
        if (tail.p.p != null) {
            tail.p.p.n = tail;
        }
        tail.p = tail.p.p;
        size--;
        return true;
    }

    public int getFront() {
        if (size == 0) {
            return -1;
        }
        return head.n.v;
    }

    public int getRear() {
        if (size == 0) {
            return -1;
        }
        return tail.p.v;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max_size;

    }

    public static void main(String[] args) {
        var dq = new MyCircularDeque(100);
        dq.insertFront(9);
        System.out.println(dq.getRear());
    }
}

class Node {
    public int v;
    public Node n;
    public Node p;

    public Node() {
        v = -666;
        n = null;
        p = null;
    }
}
/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
// @lc code=end
