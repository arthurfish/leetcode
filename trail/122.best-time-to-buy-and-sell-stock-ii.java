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
        var stack = new Stack<Integer>();
        for(var e: prices) {
            while(!stack.isEmpty() && stack.peek() == e){
                stack.pop();
            }
            stack.add(e);
        }
        prices = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0 ; i--) {
            prices[i] = stack.pop();
        }
        if(prices.length == 1) {
            return 0;
        }
        int[] mark = new int[prices.length];
        for (int i = 1; i < prices.length - 1; i++) {
            if((prices[i-1] - prices[i]) * (prices[i] - prices[i + 1]) > 0) {
                mark[i] = 1;
            }
        }
        var list = new LinkedList<Integer>();
        for (int i = 0; i < prices.length; i++) {
            if(mark[i] != 1) {
                list.addLast(prices[i]);
            }
        }
        // System.out.println("> "+list);
        boolean willPollFirst = false;
        boolean willPollLast = false;
        if(list.size() >= 2 && list.get(0) > list.get(1)){
            willPollFirst = true;
            
        }
        if(list.size() >= 2 && list.get(list.size() - 2) > list.get(list.size() - 1)) {
            willPollLast = true;
            
        }
        if(willPollFirst){
            list.pollFirst();
        }
        if(willPollLast){
            list.pollLast();
        }
        if(list.size() % 2 != 0){
            // System.out.println("Fuck Fuck Fuck!");
            System.out.println(list.size());
            // System.out.println(list);
            return -1;
        }
        int profit = 0;
        System.out.println(list);
        int list_size = list.size();
        for (int i = 0; i < list_size; i+=2) {
            int a = list.pollFirst();
            int b = list.pollFirst();
            // System.out.printf("a:%d, b:%d\n", a, b);
            profit += b - a;
        }
        return profit;
    }
    public static void main(String[] args) {
        var prices = new int[]{3, 3};
        var ans = new Solution().maxProfit(prices);
        System.out.println(ans);
    }
}
// @lc code=end

