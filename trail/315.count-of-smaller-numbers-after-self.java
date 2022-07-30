import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;

/*
 * @lc app=leetcode id=315 lang=java
 *
 * [315] Count of Smaller Numbers After Self
 */

// @lc code=start
class Solution {
    // public List<Integer> countSmaller(int[] nums) {
    // var table = new int[20002];
    // var offset = 10000;
    // var list = new LinkedList<Integer>();
    // for(int i = nums.length - 1; i >= 0; i--){
    // for(int j = nums[i] + 1; j + offset < table.length; j++) {
    // table[j + offset]++;
    // }
    // list.addFirst(table[nums[i]+offset]);
    // }
    // return list;
    // }
    public List<Integer> countSmaller(int[] nums) {
        var set = new LinkedHashSet<Integer>();
        var temp_nums = new int[nums.length];
        System.arraycopy(nums, 0, temp_nums, 0, nums.length);
        Arrays.sort(temp_nums);
        for (var e : temp_nums) {
            set.add(e);
        }
        Integer[] sorted_array = set.toArray(new Integer[1]);
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < sorted_array.length; i++) {
            map.put(sorted_array[i], i);
        }
        var max_array = new int[nums.length];
        nums[0] = map.get(nums[0]);
        max_array[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = map.get(nums[i]);
            max_array[i] = Math.max(nums[i], max_array[i - 1]);
        }
        var out_list = new Integer[nums.length];
        var table = new int[sorted_array.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int limit = Math.min(max_array[i] + 1, sorted_array.length);
            for (int j = nums[i] + 1; j < limit; j++) {
                table[j]++;
            }
            out_list[i] = table[nums[i]];
        }
        return Arrays.asList(out_list);
    }

    public static void main(String[] args) throws Exception{
        var nums = new int[] { 5, 2, 6, 1 };
        var a = new Solution().countSmaller(nums);
        System.out.println(a);

        // var path = "/home/arthur/leetcode/in.txt";
        // 
        // var input = new Scanner(Paths.get(path));
        // var nums2 = new LinkedList<Integer>();
        // while(input.hasNextInt()){
        //     nums2.add(input.nextInt());
        // }
        // var nums3 = new int[nums2.size()];
        // for(int i = 0; i < nums3.length; i++){
        //     nums3[i] = nums2.pollFirst();
        // }
        // long stat_time = System.currentTimeMillis();
        // var b = new Solution().countSmaller(nums3);
        // long end_time = System.currentTimeMillis();
        // System.out.println((end_time - stat_time));
    }
}
// @lc code=end
