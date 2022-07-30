import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=315 lang=java
 *
 * [315] Count of Smaller Numbers After Self
 */

// @lc code=start
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        MyList assistList = new MyList();
        var head = assistList.head;
        var tail = assistList.tail;
        var out_array = new Integer[nums.length];
        for(int i = nums.length - 1; i >= 0; i--){
            Node convinient_node = null;
            int pointer = 0;
            for(var node = tail.p; node != null && node != head; node = node.p) {
                if (node.v >= nums[i]){
                    convinient_node = node;
                    break;
                }
                pointer++;
            }
            out_array[i] = pointer;
            if(convinient_node == null){
                assistList.addFirst(nums[i]);
            }else{
                var node = new Node();
                node.v = nums[i];
                node.p = convinient_node;
                node.n = convinient_node.n;
                convinient_node.n.p = node;
                convinient_node.n = node;
            }
        }
        // System.out.println(head);
        return Arrays.asList(out_array);
    }
    public static void main(String[] args) {
        var nums = new int[]{5, 2, 6, 1};
        var result = new Solution().countSmaller(nums);
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
}


// @lc code=end

