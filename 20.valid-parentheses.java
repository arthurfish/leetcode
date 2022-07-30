import java.util.LinkedList;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start

class Solution {
    public boolean isValid(String s) {
        if (s.length() == 1) {
            return false;
        }
        var stack = new LinkedList<Byte>();
        for (var c : s.getBytes()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.size() == 0){
                    return false;
                }
                var top = stack.pop();
                System.out.println(String.format("c:%c top:%c", c, top));
                if (top == '(' && c != ')') {
                    return false;
                }
                if (top == '[' && c != ']') {
                    return false;
                }
                if (top == '{' && c != '}') {
                    return false;
                }
            }
        }
        if (stack.size() != 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        var a = new Solution().isValid("({[]})");
        var b = new Solution().isValid("()");
        var c = (new Solution().isValid("({[[})"));
        var d = (new Solution().isValid("({[[})"));
        var e = (new Solution().isValid("({[}[})"));;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
    }
}
// @lc code=end

