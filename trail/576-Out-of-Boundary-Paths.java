public class Solution1 {
    static int result;
    static int[] vx = { -1, +1, +0, +0};
    static int[] vy = { +0, +0, -1, +1 };

    static boolean isOutOfBound(int m, int n, int x, int y) {
        if (0 <= x && x < m && 0 <= y && y < n) {
            return false;
        }
        return true;
    }

    void dfs(int m, int n, int x, int y, int remain_steps) {
        //System.out.printf("x:%d y:%d rs:%d result:%d\n", x, y, remain_steps, result);
        if (remain_steps < 0) {
            return;
        }
        if (isOutOfBound(m, n, x, y)) {
            //System.out.println("Add.");
            result = (result + 1) % 1000000007;
            return;
        }
        for (int i = 0; i < 4; i++) {
            dfs(m, n, x + vx[i], y + vy[i], remain_steps - 1);
        }
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        result = 0;
        dfs(m, n, startRow, startColumn, maxMove);
        return result;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int a = s.findPaths(1, 3, 3, 0, 1);
        System.out.println(a);
    }
}
