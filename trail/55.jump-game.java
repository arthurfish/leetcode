/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {

    public boolean canJump(int[] nums) {
        int start = 0, end = 0;
        end = start + nums[0];
        while(true){
            if(end >= nums.length - 1){
                return true;
            }
            end = Math.max(start + nums[start], end);
            if(start == end){
                break;
            }
            start++;
        }
        return false;
    }
    public static void main(String[] args) {
        var nums = new int[]{3,0,8,2,0,0,1};
        var ans = new Solution().canJump(nums);
        System.out.println(ans);
    }
}
// @lc code=end
