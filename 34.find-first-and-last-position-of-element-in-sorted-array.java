import java.util.Arrays;

/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    int target;
    int[] array;
    int INF = Integer.MAX_VALUE;

    public int f(int l, int r) {
        if (r - l == 1) {
            if (array[l] == target) {
                return l;
            } else {
                return -1;
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

    int g(int l, int r) { // /-
        System.out.printf("l:%d r:%d\n", l, r);
        if (r - l == 1) {
            if(array[l] == target && l >= 1 && array[l - 1] < target) {
                return l;
            }
            System.out.println("Fuc");
        }
        var m = (l + r) / 2;
        if (array[m - 1] < target && array[m] == target) {
            return m;
        }
        if (array[m] == target) {
            return g(l, m);
        } else {
            return g(m, r);
        }
    }

    int u(int l, int r) { // --/
        System.out.printf("l:%d r:%d\n", l, r);
        if (r - l == 1) {
            if(array[l] == target && r < array.length - 1 && array[r + 1] > target) {
                return l;
            }
            System.out.println("Fuc");
            System.exit(0);
        }

        var m = (l + r) / 2;
        System.out.println("m: "+m);
        if (array[m] == target && array[m + 1] > target) {
            return m;
        }
        if (array[m] == target) {
            return u(m, r);
        } else {
            return u(l, m);
        }
    }


    public int[] searchRange(int[] nums, int target) {
        var temp_nums = new int[nums.length + 2];
        temp_nums[0] = -INF;
        temp_nums[nums.length + 1] = INF;
        System.arraycopy(nums, 0, temp_nums, 1, nums.length);
        nums = temp_nums;
        this.array = nums;
        this.target = target;
        // System.out.println(Arrays.toString(nums));

        var search_result = f(0, nums.length);
        if (search_result == -1) {
            return new int[] { -1, -1 };
        }

        var left_boundary = g(1, search_result + 1);
        System.out.println("lb: "+left_boundary);
        System.out.println(Arrays.toString(array));
        var right_boundary = u(search_result, nums.length);

        return new int[] { left_boundary - 1, right_boundary - 1};
    }

    public static void main(String[] args) {
        var nums = new int[] {5,7,7,8,8,10};
        var target = 8;
        var ans = new Solution().searchRange(nums, target);
        System.out.println(Arrays.toString(ans));
    }
}
// @lc code=end
