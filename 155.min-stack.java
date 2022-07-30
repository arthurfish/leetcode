import java.util.LinkedList;

/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start
class MinStack {
    LinkedList<Integer> stack = new LinkedList<Integer>();
    LinkedList<Integer> assistStack = new LinkedList<Integer>();
    public MinStack() {
        assistStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        stack.push(val);
        assistStack.push(Math.min(assistStack.peek(), val));
    }
    
    public void pop() {
        stack.pop();
        assistStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return assistStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

