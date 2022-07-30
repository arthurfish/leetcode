import java.util.Arrays;

/*
 * @lc app=leetcode id=455 lang=java
 *
 * [455] Assign Cookies
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(g.length == 0 || s.length == 0){
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int content_count = 0;
        int ps = 0;
        int pg = 0;
        while(pg != g.length && ps != s.length){
            if(s[ps] >= g[pg]){
                ps++;
                pg++;
                content_count++;
            }else{
                ps++;
            }
        }
        return content_count;
    }
    public static void main(String[] args) {
        int[] g = new int[]{10, 9, 8, 7};
        int[] s = new int[]{5, 6, 7, 8};
        int result = new Solution().findContentChildren(g, s);
        System.out.println(result);
    }
}
// @lc code=end

