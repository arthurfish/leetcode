/*
 * @lc app=leetcode id=860 lang=java
 *
 * [860] Lemonade Change
 */

// @lc code=start
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
        int twentys = 0;
        for (var bill : bills) {
            if (bill == 5) {
                fives++;
            } else if (bill == 10) {
                if (fives <= 0) {
                    return false;
                }
                fives--;
                tens++;
            } else if (bill == 20) {
                if (tens > 0 && fives > 0) {
                    tens--;
                    fives--;
                    twentys++;
                }else if(fives >= 3){
                    fives -= 3;
                    twentys++;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] bills = new int[]{5,5,10,10,20};
        boolean ans = new Solution().lemonadeChange(bills);
        System.out.println(ans);
    }
}
// @lc code=end
