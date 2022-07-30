import java.util.Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    // public int trap(int[] height) {
    // if (height.length <= 2) {
    // return 0;
    // }
    // var stack = new Stack<Integer>();
    // stack.push(height[0]);
    // var themax = height[0];
    // var water = 0;
    // for (int flag = 0; flag < 2; flag++) {
    // for (int i = 1; i < height.length; i++) {
    // if (height[i] >= themax) {
    // while (!stack.empty()) {
    // water += themax - stack.pop();
    // }
    // themax = height[i];
    // stack.push(height[i]);
    // } else {
    // stack.push(height[i]);
    // }
    // }
    // if (flag == 0) {
    // var newHeight = new int[stack.size()];
    // for(int i = 0; i < newHeight.length; i++){
    // newHeight[i] = stack.pop();
    // }
    // height = newHeight;
    // themax = newHeight[0];
    // }
    // }
    // return water;
    // }

    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        // int globalMax = Arrays.stream(height).max().orElse(-1);
        int globalMax = Integer.MIN_VALUE;
        for(var e: height) {
            if(e > globalMax){
                globalMax = e;
            }
        }
        // System.out.println("gm: " + globalMax);
        var specialPos = -666;
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] == globalMax) {
                specialPos = i;
            }
        }

        // System.out.println("sp: " + specialPos);
        for (int i = specialPos + 1; i <= (specialPos + 1 + height.length - 1) / 2; i++) {
            var pos = (height.length - 1) - (i - (specialPos + 1));
            // System.out.println("i:"+i+" pos: "+pos);
            var temp = height[pos];
            height[pos] = height[i];
            height[i] = temp;
        }
        var newHeight = new int[height.length + 1];
        System.arraycopy(height, 0, newHeight, 0, height.length);
        newHeight[height.length] = globalMax;
        height = newHeight;
        // System.out.println(Arrays.toString(height));
        int themax = height[0];
        int water = 0;
        for (int i = 1; i < height.length; i++) {
            themax = Math.max(height[i], themax);
            if (i == specialPos + 1) {
                themax = height[i];
            }
            water += themax - height[i];
            // System.out.print("i: "+i);
            // System.out.println(" t-h: "+(themax-height[i]));
        }
        return water;
    }

    public static void main(String[] args) {
        var height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        var result = new Solution().trap(height);
        System.out.println(result);
    }
}
// @lc code=end
