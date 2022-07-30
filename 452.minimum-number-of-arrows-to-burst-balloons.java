import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=452 lang=java
 *
 * [452] Minimum Number of Arrows to Burst Balloons
 */

// @lc code=start
class Solution {
    int inf = Integer.MAX_VALUE;
    public int findMinArrowShots(int[][] points) {
        var range_arr = new Range[points.length];
        PriorityQueue<Range> range_pq = new PriorityQueue<Range>((Range a, Range b) ->  (a.b > b.b) ? -1 : ((a.b == b.b ? 0 : 1)));
        for (int i = 0; i < range_arr.length; i++) {
            int a = points[i][0];
            int b = points[i][1];
            range_arr[i] = new Range(a, b);
        }
        Arrays.sort(range_arr, (Range a, Range b) -> (a.a > b.a) ? -1 : ((a.a == b.a) ? 0 : 1));
        for (int i = 0; i < range_arr.length; i++) {
            int a = range_arr[i].a;
            int b = range_arr[i].b;
            range_pq.add(new Range(a, b, i));
        }
        int strike_count = 0;
        for (int i = 0; i < range_arr.length; i++) {
            // System.out.println(Arrays.toString(range_arr));
            if(range_arr[i] == null) {
                continue;
            }
            while(range_pq.size() != 0 && range_pq.peek().b >= range_arr[i].a) {
                var top = range_pq.peek();    
                range_pq.poll();
                if(top.i == i){
                    continue;
                }
                range_arr[(int)top.i] = null;
            }
            strike_count++;
        }
        return (int)strike_count;
    }
    public static void main(String[] args) {
        // var ranges = new Range[4];
        // ranges[0] = new Range(1, 3);
        // ranges[1] = new Range(3, 6);
        // ranges[2] = new Range(6, 9);
        // ranges[3] = new Range(2, 2);
        // Arrays.sort(ranges, (Range a, Range b) -> -(a.a - b.a));
        // System.out.println(Arrays.toString(ranges));

        // var pq = new PriorityQueue<Range>((Range a, Range b) ->  -(a.b - b.b));
        // pq.add(ranges[0]);
        // pq.add(ranges[1]);
        // pq.add(ranges[2]);
        // pq.add(ranges[3]);
        // System.out.println(pq.poll());
        // System.out.println(pq.poll());
        // System.out.println(pq.poll());
        // System.out.println(pq.poll());
        // int[][] points = new int[][]{{10,16},{2,8},{1,6},{7,12}};
        // int[][] points = new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}};
        int[][] points = new int[][]{{-10001,-10000},{10000,10001}};
        var ans = new Solution().findMinArrowShots(points);
        System.out.println(ans);
    }
}

class Range {
    int a;
    int b;
    int i;

    public Range(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Range(int a, int b, int i) {
        this.a = a;
        this.b = b;
        this.i = i;
    }

    // @Override
    // public int compareTo(Range that){
    //     return (int)(this.b - that.b);
    // }

    @Override
    public String toString() {
        return String.format("(%d, %d)", a, b);
    }
}
// @lc code=end

