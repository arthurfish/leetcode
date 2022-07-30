import java.util.Arrays;
/*
 * @lc app=leetcode id=977 lang=java
 *
 * [977] Squares of a Sorted Array
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        int positive_start_pos = nums.length;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= 0){
                positive_start_pos = i;
                break;
            }
        }
        for(int i = 0; i < positive_start_pos / 2; i++){
            int temp = nums[i];
            nums[i] = nums[positive_start_pos - 1 - i];
            nums[positive_start_pos - 1 - i] = temp;
        }
        int p1 = 0, p2 = positive_start_pos, p3 = 0;
        var out_array = new int[nums.length];
        while(!(p1 == positive_start_pos && p2 == nums.length)){
            if(p1 == positive_start_pos){
                out_array[p3++] = nums[p2] * nums[p2];
                p2++;
                continue;
            }
            if(p2 == nums.length){
                out_array[p3++] = nums[p1] * nums[p1];
                p1++;
                continue;
            }
            if(Math.abs(nums[p1]) < Math.abs(nums[p2])){
                out_array[p3++] = nums[p1] * nums[p1];
                p1++;
            }else{
                out_array[p3++] = nums[p2] * nums[p2];
                p2++;
            }
        }
        return out_array;
    }
    public static void main(String[] args) {
        int[] test = new int[]{-7,-3};
        int[] result = new Solution().sortedSquares(test);
        System.out.println(Arrays.toString(result));

    }
}
// @lc code=end

