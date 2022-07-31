import java.util.Stack;

/*
 * @lc app=leetcode id=402 lang=java
 *
 * [402] Remove K Digits
 */

// @lc code=start
class Solution {
    int inf = Integer.MAX_VALUE;

    public String removeKdigits(String num, int k) {        
        var stack = new Stack<Character>();
        for(var c: num.toCharArray()){
            while(!stack.empty() && k > 0 && stack.peek() > c){
                stack.pop();
                k--;
            }
            if(!(stack.empty() && c == '0')) {
                stack.add(c);
            }
        }
        // System.out.println(stack);
        // System.out.println(k);
        while(!stack.empty() && k > 0){
            stack.pop();
            k--;
        }
        if(stack.empty()){
            stack.add('0');
        }
        var s = new StringBuilder();
        stack.forEach(s::append);
        return s.toString();
    }
    public static void main(String[] args) {
        String num = "112";
        String result = new Solution().removeKdigits(num, 1);
        System.out.println(result);
    }
}
// @lc code=end

