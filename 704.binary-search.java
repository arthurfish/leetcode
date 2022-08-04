/*
 * @lc app=leetcode id=704 lang=java
 *
 * [704] Binary Search
 */

// @lc code=start
class Solution {
    int target;
    int[] array;
    public int f(int l, int r) {
        if(r - l == 1) {
            if(array[l] == target){
                return l;
            }else{
                return -1;
            }
        }
        int m = (l + r) / 2;
        if(array[m] == target){
            return m;
        }else if(array[m] < target){
            return f(m, r);
        }else{
            return f(l, m);
        }
    }
    public int search(int[] nums, int target) {
        this.array = nums;
        this.target = target;
        return f(0, nums.length);
    }

    public static void main(String[] args) {
        var nums = new int[]{-1,0,3,5,9,12};
        var target = 9;
        var ans = new Solution().search(nums, target);
        System.out.println(ans);
    }
}
// @lc code=end

