import java.text.Collator;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=402 lang=java
 *
 * [402] Remove K Digits
 */

// @lc code=start
class Solution {
    int inf = Integer.MAX_VALUE;

    public void removeOneDigit(MyList list, Node head, int k){
        if(k == 0) {
            return;
        }
        if(head == list.head) {
            head = list.head.n;
        }
        // System.out.println(list.head);
        for(var node = head; node != list.tail; node = node.n) {
            Node nextNode;
            if(node.n == list.tail){
                nextNode = new Node();
                nextNode.v = 0;
            }else{
                nextNode = node.n;
            }
            // System.out.println("node.v: "+node.v);
            if(node.v > nextNode.v) {
                var node_p_cache = node.p;
                list.remove(node);
                removeOneDigit(list, node_p_cache, k - 1);
                return;
            }
        }
    }

    public String removeKdigits(String num, int k) {        
        var list = new MyList();
        for(var e: num.toCharArray()) {
            list.addLast(e - '0');
        }
        removeOneDigit(list, list.head.n, k);
        for(var node = list.head.n; node != list.tail; node = node.n){
            if(node.v != 0){
                break;
            }else{
                list.remove(node);
            }
        }
        if(list.head.n == list.tail){
            list.addLast(0);
        }
        // System.out.println(list.head.n);
        var s = new StringBuilder();
        for(var node = list.head.n; node != list.tail; node = node.n){
            s.append(node.v);
        }
        return s.toString();
    }
    public static void main(String[] args) {
        String num = "10200";
        String result = new Solution().removeKdigits(num, 1);
        System.out.println(result);
    }
}

class Node{
    public Node n;
    public Node p;
    public int v;
    @Override
    public String toString() {
        return String.format("%d -> %s", v, n);
    }

    public Node(int v){
        this.v = v;
    }

    public Node(){

    }
}

class MyList{
    public Node head = new Node();
    public Node tail = new Node();
    public MyList(){
        head.n = tail;
        tail.p = head;
        head.v = Integer.MAX_VALUE;
        tail.v = Integer.MAX_VALUE;
    }
    public void addFirst(int e){
        var node = new Node();
        node.v = e;
        node.n = head.n;
        if(head.n != null){
            head.n.p = node;
        }
        head.n = node;
    }
    public void addLast(int e){
        var node = new Node();
        node.v = e;
        node.n = tail;
        node.p = tail.p;
        if(tail.p != null){
            tail.p.n = node;
        }
        tail.p = node;
    }

    public void remove(Node node){
        // System.out.println("Will remove node: " + node.v);
        node.p.n = node.n;
        node.n.p = node.p;
    }
}
// @lc code=end

