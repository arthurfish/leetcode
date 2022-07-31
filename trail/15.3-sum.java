import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int[] negatives = Arrays.stream(nums).unordered().filter(x -> x < 0).sorted().toArray();
        int[] zeros = Arrays.stream(nums).unordered().filter(x -> x == 0).toArray();
        int[] positives = Arrays.stream(nums).unordered().filter(x -> x > 0).sorted().toArray();
        var set = new HashSet<Triple>();
        // One negative, Two positives.
        for (int i = 0; i < positives.length; i++) {
            for (int j = i + 1; j < positives.length; j++) {
                int search_result = Arrays.binarySearch(negatives, -(positives[i] + positives[j]));
                if (search_result >= 0) {
                    var triple = new Triple(positives[i], positives[j], negatives[search_result]);
                    set.add(triple);
                }
            }
        }

        // One positive, Two negatives.
        for (int i = 0; i < negatives.length; i++) {
            for (int j = i + 1; j < negatives.length; j++) {
                int search_result = Arrays.binarySearch(positives, -(negatives[i] + negatives[j]));
                if (search_result >= 0) {
                    var triple = new Triple(negatives[i], negatives[j], positives[search_result]);
                    set.add(triple);
                }
            }
        }

        // One positive, One zero, One negatives;
        if (zeros.length > 0) {
            for (int i = 0; i < positives.length; i++) {
                int search_result = Arrays.binarySearch(negatives, -positives[i]);
                if (search_result >= 0) {
                    var triple = new Triple(positives[i], negatives[search_result], 0);
                    set.add(triple);
                }
            }
        }

        // Three Zeros
        if (zeros.length >= 3) {
            var triple = new Triple(0, 0, 0);
            set.add(triple);
        }
        
        // System.out.println(set);
        var ans_list = new LinkedList<List<Integer>>();
        for (var triple : set) {
            var temp_list = new LinkedList<Integer>();
            temp_list.add(triple.a);
            temp_list.add(triple.b);
            temp_list.add(triple.c);
            ans_list.add(temp_list);
        }
        return ans_list;
    }

    public static void main(String[] args) {
        var nums = new int[] { -2, 0, 0, 2, 2 };
        var ans = new Solution().threeSum(nums);
        System.out.println(ans);
    }
}

class Triple {
    public int a;
    public int b;
    public int c;

    public Triple(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that)
            return true;
        if (!(that instanceof Triple))
            return false;
        Triple it = (Triple) that;
        boolean isEqual = this.a == it.a && this.b == it.b && this.c == it.c;
        // System.out.printf("%s == %s ? %d", this, it, this == it);
        return isEqual;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(a) + Integer.hashCode(b) + Integer.hashCode(c);
    }

    @Override
    public String toString() {
        return String.format("(%d|%d|%d) ", a, b, c);
    }
}
// @lc code=end
