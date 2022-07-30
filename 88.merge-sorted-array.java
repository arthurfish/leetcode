import java.util.Arrays;

/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] p = new int[m+1];
        int[] q = new int[n+1];
        var y = nums1;
        System.arraycopy(nums1, 0, p, 0, m);
        System.arraycopy(nums2, 0, q, 0, n);
        p[m] = Integer.MAX_VALUE;
        q[n] = Integer.MAX_VALUE;
        int py = 0, pp =0, pq = 0;
        while(py != y.length) {
            if (p[pp] < q[pq]) {
                y[py++] = p[pp++];
            }else{
                y[py++] = q[pq++];
            }
        }
        // System.out.println(Arrays.toString(y));
    }
    public static void main(String[] args) {
        var nums1 = new int[]{1,2,3,0,0,0};
        var m = 3;
        var nums2 = new int[]{2,5,6};
        var n = 3;
        new Solution().merge(nums1, m, nums2, n);;
        
    }
}
// @lc code=end

