/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 */

// @lc code=start
class Solution {
    int target;
    int[] array;

    public int f(int l, int r) {
        System.out.printf("l:%d r:%d\n", l, r);
        if (r - l == 1) {
            if(array[l] == target){
                return l;
            }
            if(array[l] < target){
                return l + 1;
            }
            if(array[l] > target){
                return l;
            }
            return l + 1;
        }
        if (r - l == 2){
            if(array[l] != target && array[r - 1] != target){
                if(target < array[l]) {
                    return l;
                }else if(target < array[r - 1]){
                    return r - 1;
                }else{
                    return r;
                }
            }
        }
        int m = (l + r) / 2;
        if (array[m] == target) {
            return m;
        } else if (array[m] < target) {
            return f(m, r);
        } else {
            return f(l, m);
        }
    }

    public int searchInsert(int[] nums, int target) {
        this.array = nums;
        this.target = target;
        return f(0, nums.length);
    }

    public static void main(String[] args) {
        var nums = new int[] {1};
        var target = 0;
        var ans = new Solution().searchInsert(nums, target);
        System.out.println(ans);
    }
}
// @lc code=end
