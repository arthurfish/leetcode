import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=376 lang=java
 *
 * [376] Wiggle Subsequence
 */

// @lc code=start
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        int last = nums[0];
        int wiggle_count = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 1; i < nums.length; i++) {
            int deviate = nums[i-1] - nums[i];
            if(deviate < 0) {
                // nums[i] = -1;
                queue.add(-1);
            }
            if(deviate == 0){
                // nums[i] = 0;
                // queue.add(1);
            }
            if(deviate > 0){
                // nums[i] = 1;
                queue.add(1);
            }
        }
        // System.out.println(queue);
        while(!queue.isEmpty()){
            var e = queue.poll();
            while(!queue.isEmpty() && queue.peek() == e){
                queue.poll();
            }
            wiggle_count++;
        }
        return wiggle_count + 1;
    }
    public static void main(String[] args) {
        var nums = new int[]{1,1,7,4,9,2,5};
        int result = new Solution().wiggleMaxLength(nums);
        System.out.println(result);
    }
}


