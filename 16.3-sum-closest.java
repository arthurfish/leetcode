import java.util.Arrays;

/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int INF = Integer.MAX_VALUE;
        int closest = INF;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int p1 = i + 1, p2 = nums.length - 1;
            while(p2 > p1){
                int sum = nums[i] + nums[p1] + nums[p2];
                if(Math.abs(closest - target) > Math.abs(sum - target)) {
                    closest = sum;
                }
                if(sum >= target){
                    p2--;
                }else{
                    p1++;
                }
            }
        }
        return closest;
    }
    public static void main(String[] args) {
        var nums = new int[] {-1,2,1,-4};
        var ans = new Solution().threeSumClosest(nums, 1);
        System.out.println(ans);
    }
}
// @lc code=end

