import java.util.Arrays;
import java.util.Stack;

/*
 * @lc app=leetcode id=946 lang=java
 *
 * [946] Validate Stack Sequences
 */

// @lc code=start
class Solution {
    // public boolean validateStackSequences(int[] pushed, int[] popped) {
    //     Stack<Integer> stack = new Stack<Integer>();
    //     Stack<Integer> spush = new Stack<Integer>();
    //     Stack<Integer> spop = new Stack<Integer>();
    //     for (int i = pushed.length - 1; i >= 0; i--) {
    //         spush.push(pushed[i]);
    //     }
    //     for (int i = popped.length - 1; i >= 0; i--) {
    //         spop.push(popped[i]);
    //     }

    //     // System.out.println(spop);
    //     while (spush.size() > 0) {
    //         var x = spush.pop();
    //         stack.push(x);
    //         System.out.println("Here!");
    //         while (stack.size() > 0 && spop.size() > 0 && stack.peek() == spop.peek()) {
    //             System.out.println("eqaul!");
    //             stack.pop();
    //             spop.pop();
    //         }
    //         System.out.println("Not Here.");
    //         System.out.println("spush: " + spush);
    //         System.out.println("spop: " + spop);
    //         System.out.println("stack: " + stack);
    //     }
    //     if(spush.size() == 0 && spop.size() == 0 && stack.size() == 0)
    //         return true;
    //     else
    //         return false;
    // }
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<Integer>();
        int ppop = 0;
        for(var e: pushed){
            stack.push(e);
            while(stack.size() != 0 && stack.peek() == popped[ppop]){
                stack.pop();
                ppop++;
            }
        }
        if (ppop == pushed.length) {
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        var pushed = new int[] { 1, 2, 3, 4, 5 };
        var popped = new int[] { 4, 5, 3, 2, 1 };
        // var result = new Solution().validateStackSequences(pushed, popped);


        pushed = new int[]{1, 2, 3, 4, 5};
        popped = new int[]{4,3,5,1,2};
        new Solution().validateStackSequences(pushed, popped);

    }
}
// @lc code=end
