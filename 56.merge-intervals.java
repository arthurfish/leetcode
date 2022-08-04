import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>();
        for(var interval : intervals) {
            pq.add(new Interval(interval[0], interval[1]));
        }
        var stack = new Stack<Interval>();
        while(!pq.isEmpty()){
            var interval = pq.poll();
            if(stack.empty() || stack.peek().r < interval.l){
                stack.push(interval);
                continue;
            }else{
                var new_interval = new Interval();
                new_interval.r = Math.max(interval.r, stack.peek().r);
                new_interval.l = stack.pop().l;
                stack.push(new_interval);
            }
        }
        System.out.println(stack);
        var out_matrix = new int[stack.size()][2];
        var out_matrix_pointer = 0;
        for(var interval: stack){
            out_matrix[out_matrix_pointer][0] = interval.l;
            out_matrix[out_matrix_pointer][1] = interval.r;
            out_matrix_pointer++;
        }
        return out_matrix;
    }

    public static void main(String[] args) {
        // var intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        var intervals = new int[][] { { 1, 4 }, { 4, 5 } };
        var ans = new Solution().merge(intervals);
        System.out.println(Arrays.deepToString(ans));
    }
}

class Interval implements Comparable<Interval>{
    int l;
    int r;

    public Interval(int l, int r) {
        this.l = l;
        this.r = r;
    }

    public Interval() {
    }

    @Override
    public int compareTo(Interval that) {
        return this.l -that.l;
    }

    @Override
    public String toString() {
        return String.format("[%d %d]", l, r);
    }
}
// @lc code=end
