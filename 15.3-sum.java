import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int negative_boundary = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negative_boundary++;
            }
        }
        int positive_boundary = nums.length;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > 0) {
                positive_boundary--;
            }
        }
        int zero_number = (positive_boundary - negative_boundary) - 1;

        int offset = 200001;
        boolean[] positive_bucket = new boolean[2 * offset];
        boolean[] negative_bucket = new boolean[2 * offset];
        for (int i = 0; i <= negative_boundary; i++) {
            negative_bucket[nums[i] + offset] = true;
        }
        for (int i = positive_boundary; i < nums.length; i++) {
            positive_bucket[nums[i] + offset] = true;
        }

        // Output set

        Set<Triple> set = new TreeSet<Triple>();

        // One positive, two negatives.
        for (int i = 0; i <= negative_boundary; i++) {
            for (int j = i + 1; j <= negative_boundary; j++) {
                if (positive_bucket[-(nums[i] + nums[j]) + offset]) {
                    if (nums[i] > nums[j]) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                    set.add(new Triple(nums[i], nums[j], -(nums[i] + nums[j])));
                }
            }
        }

        // One negative, two positives
        for (int i = positive_boundary; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (negative_bucket[-(nums[i] + nums[j]) + offset] == true) {
                    if (nums[i] > nums[j]) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                    set.add(new Triple(nums[i], nums[j], -(nums[i] + nums[j])));
                }
            }
        }

        // One negative, one zero, one positive.
        if (zero_number != 0) {
            for (int i = 0; i <= negative_boundary; i++) {
                if (positive_bucket[-nums[i] + offset] == true) {
                    set.add(new Triple(nums[i], -nums[i], 0));
                }
            }
        }

        // All Zero?
        if (zero_number >= 3) {
            set.add(new Triple(0, 0, 0));
        }

        // Output list<lits<>>
        List<List<Integer>> ans_list = new ArrayList<List<Integer>>();
        for (var triple : set) {
            int a = triple.a;
            int b = triple.b;
            int c = triple.c;
            ans_list.add(Arrays.asList(new Integer[] { a, b, c }));
        }

        return ans_list;
    }

    public static void main(String[] args) {
        var nums = new int[] { -1, 0, 1, 2, -1, -4 };
        var ans = new Solution().threeSum(nums);
        System.out.println(ans);
    }
}

class Triple implements Comparable<Triple> {
    public int a;
    public int b;
    public int c;

    public Triple(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public int compareTo(Triple that) {
        if (this.a != that.a) {
            return this.a - that.a;
        }
        if (this.b != that.b) {
            return this.b - that.b;
        }
        if (this.c != that.c) {
            return this.c - that.c;
        }
        return 0;
    }

}

// @lc code=end
