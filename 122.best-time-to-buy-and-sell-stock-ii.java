import java.util.LinkedList;
import java.util.Stack;

/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int deviate = prices[i] - prices[i - 1];
            if(deviate > 0){
                profit += deviate;
            }
        }
        return profit;
    }
}
// @lc code=end

