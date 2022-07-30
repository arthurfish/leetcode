import java.util.Arrays;

/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        var a1 = s.toCharArray();
        var a2 = t.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        boolean isAnagram = true;
        for(int i = 0; i < s.length(); i++){
            if(a1[i] != a2[i]){
                isAnagram = false;
            }
        }
        return isAnagram;
    }
}
// @lc code=end

