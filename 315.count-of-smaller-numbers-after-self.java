import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=315 lang=java
 *
 * [315] Count of Smaller Numbers After Self
 */

// @lc code=start
class Solution {
    Integer[] out_array;
    int[] indices;

    public List<Integer> countSmaller(int[] nums) {
        out_array = new Integer[nums.length];
        for (int i = 0; i < out_array.length; i++) {
            out_array[i] = 0;
        }
        indices = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indices[i] = i;
        }
        MergeSort(nums, 0, nums.length - 1);
        return Arrays.asList(out_array);
    }

    void MergeSort(int[] nums, int l, int r) {
        if (r - l + 1 == 1) {
            return;
        }
        int pivot = (l + r + 1) / 2 - 1;
        MergeSort(nums, l, pivot);
        MergeSort(nums, pivot + 1, r);
        int p1 = l, p2 = pivot + 1, p3 = 0;
        int[] arr = new int[r - l + 1];
        int[] new_indices = new int[r - l + 1];
        int continue_count = 0;
        while (!(p1 == pivot + 1 && p2 == r + 1)) {
            if (p1 == pivot + 1) {
                if (continue_count != 0) {
                    out_array[new_indices[p1 - l]] += continue_count;
                }
                new_indices[p3] = indices[p2];
                arr[p3++] = nums[p2++];
            } else if (p2 == r + 1) {
                if (continue_count != 0) {
                    out_array[new_indices[p1 - l]] += continue_count;
                }
                new_indices[p3] = indices[p1];
                arr[p3++] = nums[p1++];
            } else {
                if (nums[p1] > nums[p2]) {
                    new_indices[p3] = indices[p2];
                    arr[p3++] = nums[p2++];
                    //
                    continue_count++;
                    //
                } else {
                    if (continue_count != 0) {
                        out_array[new_indices[p1 -l]] += continue_count;
                    }
                    new_indices[p3] = indices[p1];
                    arr[p3++] = nums[p1++];

                }
            }
        }
        System.arraycopy(arr, 0, nums, l, r - l + 1);
        System.arraycopy(new_indices, 0, indices, l, r - l + 1);
    }

    public static void main(String[] args) {
        var nums = new int[] { 5, 2, 6, 1 };
        var result = new Solution().countSmaller(nums);
        System.out.println(result);
    }
}
// @lc code=end
