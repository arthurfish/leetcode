import java.text.Collator;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=402 lang=java
 *
 * [402] Remove K Digits
 */

// @lc code=start
class Solution {
    int inf = Integer.MAX_VALUE;
    String removeOneDigit(String num){
        for (int i = 0; i < num.length(); i++) {
            int this_elem = num.charAt(i);
            int next_elem;
            if(i != num.length() - 1){
                next_elem = num.charAt(i+1);
            }else{
                next_elem = 0;
            }
            if(next_elem < this_elem){
                return num.substring(0, i) + num.substring(i + 1, num.length());
            }
        }
        return null;
    }
    public String removeKdigits(String num, int k) {
        for (int i = 0; i < k; i++) {
            num = removeOneDigit(num);
        }
        while(num.length() > 0 && num.charAt(0) == '0') {
            num = num.substring(1);
        }
        if(num.length() == 0) {
            num = "0";
        }
        
        return num;
    }
    public static void main(String[] args) {
        String num = "10200";
        String result = new Solution().removeKdigits(num, 1);
        System.out.println(result);
    }
}
// @lc code=end

