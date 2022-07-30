/*
 * @lc app=leetcode id=576 lang=java
 *
 * [576] Out of Boundary Paths
 */

// @lc code=start
class Solution {
    public static void main(String[] args) {
        int a = new Solution().findPaths(2, 2, 2, 0, 0);
        System.out.println(a);
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove == 0) {
            return 0;
        }
        int[][] dp_prev = new int[m + 2][n + 2];
        int[][] dp_curr = new int[m + 2][n + 2];
        for (int i = 1; i <= m; i++) {
            dp_curr[i][1]++;
            dp_curr[i][n]++;
        }
        for (int i = 1; i <= n; i++) {
            dp_curr[1][i]++;
            dp_curr[m][i]++;
        }
        int ans = dp_curr[startRow + 1][startColumn + 1];
        for (int d = 1; d < maxMove; d++) {
            int[][] temp = dp_prev;
            dp_prev = dp_curr;
            dp_curr = temp;
            //
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    dp_curr[i][j] = (int) (((long) dp_prev[i - 1][j] + dp_prev[i + 1][j] + dp_prev[i][j - 1]
                            + dp_prev[i][j + 1]) % 1000000007);
                }
            }
            ans = (int) (((long) ans + dp_curr[startRow + 1][startColumn + 1]) % 1000000007);
        }
        return ans;
    }
}
// @lc code=end

