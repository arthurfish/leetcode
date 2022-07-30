/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    int inf = Integer.MAX_VALUE;
    // public int maxArea(int[] height) {
    //     int maximum = -inf;
    //     for(int i = 0; i < height.length; i++){
    //         for(int j = i; j < height.length; j++){
    //             maximum = Math.max(Math.min(height[i], height[j]) * (j - i), maximum);
    //         }
    //     }
    //     return maximum;
    // }
    public int maxArea(int[] height){
        int p1 = 0, p2 = height.length - 1;
        int maximum = -inf;
        while(p1 != p2){
            maximum = Math.max(Math.min(height[p1], height[p2]) * (p2 - p1), maximum);
            if(height[p1] < height[p2]){
                p1++;
            }else{
                p2--;
            }
        }
        return maximum;
    }
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int result = new Solution().maxArea(height);
        System.out.println(result);
    }
}
// @lc code=end

