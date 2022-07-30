import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     var pq = new PriorityQueue<Integer>(Collections.reverseOrder());
    //     var output = new int[nums.length - k + 1];
    //     for (int i = 0; i < k; i++) {
    //         pq.add(nums[i]);
    //     }
    //     output[0] = pq.peek();
    //     for (int i = k; i < nums.length; i++) {
    //         pq.add(nums[i]);
    //         pq.remove(nums[i - k]);
    //         output[i-k+1] = pq.peek();
    //     }
    //     return output;
    // }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1){
            return nums;
        }
        var num_dq = new ArrayDeque<Integer>(nums.length);
        var pos_dq = new ArrayDeque<Integer>(nums.length);
        num_dq.addLast(nums[0]);
        pos_dq.addLast(0);
        var output = new int[nums.length-(k-1)];
        for(int i = 1; i < nums.length; i++){
            if (pos_dq.peekFirst() <= i - k) {
                pos_dq.pollFirst();
                num_dq.pollFirst();
            }
            while(num_dq.size() > 0 && num_dq.peekLast() < nums[i]) {
                num_dq.pollLast();
                pos_dq.pollLast();
            }
            num_dq.addLast(nums[i]);
            pos_dq.addLast(i);
            if(i >= k-1){
                output[i-(k-1)]=num_dq.peekFirst();
            }
        }
        return output;
    }
    public static void main(String[] args) {
        var nums = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
        var k = 3;
        var result = new Solution().maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }
}
// @lc code=end
