import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // int[] temp_gas = new int[gas.length * 2];
        // int[] temp_cost = new int[cost.length * 2];
        // System.arraycopy(gas, 0, temp_gas, 0, gas.length);
        // System.arraycopy(gas, 0, temp_gas, gas.length, gas.length);
        // System.arraycopy(cost, 0, temp_cost, 0, cost.length);
        // System.arraycopy(cost, 0, temp_cost, cost.length, cost.length);
        // gas = temp_gas;
        // cost = temp_cost;
        SlidingWindow slidingWindow = new SlidingWindow();
        int accumulator = 0;
        for (int i = 0; i < gas.length; i++) {
            accumulator += gas[i] - cost[i];    
            // System.out.println("AC: "+accumulator);
            slidingWindow.add(new Pair(accumulator, i));
        }

        int offset = 0;
        for (int i = 0; i < gas.length; i++) {
            int breach = slidingWindow.getMin().v - offset;
            // System.out.println("Breach: " + breach);
            if(breach >= 0){
                return i;
            }
            slidingWindow.stepForward();
            accumulator += gas[i] - cost[i];
            slidingWindow.add(new Pair(accumulator, i + gas.length));
            offset += gas[i] - cost[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        var gas = new int[]{1,2,3,4,5};
        var cost = new int[]{3,4,5,1,2};
        var ans = new Solution().canCompleteCircuit(gas, cost);
        System.out.println(ans);
    }
}

class Pair{
    public int v;
    public int i;
    public Pair(int v, int i) {
        this.v = v;
        this.i = i;
    }
    public Pair() {
    }
}

class SlidingWindow {
    int pos = 0;
    Deque<Pair> deque = new LinkedList<Pair>();

    public void stepForward(){
        pos++;
        while(!deque.isEmpty() && deque.peekFirst().i < pos) {
            deque.pollFirst();
        }
    }

    void add(Pair p){
        while(!deque.isEmpty() && deque.peekLast().v >= p.v){
            deque.pollLast();
        }
        deque.addLast(p);
    }

    Pair getMin(){
        return deque.peekFirst();
    }
}
// @lc code=end

