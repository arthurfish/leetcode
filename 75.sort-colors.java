import java.util.Arrays;

/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        var count = new int[3];
        for(var e: nums){
            count[e]++;
        }
        int p = 0;
        for(int c = 0; c < 3; c++){
            for(int i = 0; i < count[c]; i++) {
                nums[p++] = c;
            }
        }
    }
    public static void main(String[] args) {
        var nums = new int[]{2, 0, 2, 1, 1, 0};
        new Solution().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
// @lc code=end

