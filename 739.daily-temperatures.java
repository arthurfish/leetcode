import java.util.Arrays;
import java.util.Stack;

/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        // int[] newTemperatures = new int[temperatures.length+1];
        // for(int i = 0; i < temperatures.length; i++) {
        //     newTemperatures[i] = temperatures[i];
        // }
        // newTemperatures[temperatures.length] = Integer.MIN_VALUE;
        // temperatures = newTemperatures;

        var stack = new Stack<Integer>();
        var assistStack = new Stack<Integer>();
        stack.push(Integer.MAX_VALUE);
        var output = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            var t = temperatures[i];
            if (t > stack.peek()) {
                while(t > stack.peek()){
                    stack.pop();
                    var pos = assistStack.pop();
                    output[pos] = i - pos;
                }
                stack.push(t);
                assistStack.push(i);
            }else{
                stack.push(t);
                assistStack.push(i);
            }
        }
        return output;
    }
    public static void main(String[] args) {
        var temperatures = new int[]{73,74,75,71,69,72,76,73};
        var result = new Solution().dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(result));
    }
}
// @lc code=end

