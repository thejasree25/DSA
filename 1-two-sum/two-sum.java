import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;
        int ans[] = new int[2];
        
        // ❌ Incorrect: hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1, i);
        // ✅ You only need to store number → index
        for (int i = 0; i < n; i++) {
            hm.put(nums[i], i);
        }

        // ✅ Now search for the two numbers whose sum = target
        for (int i = 0; i < n; i++) {
            int first = nums[i];
            int res = target - first;

            if (hm.containsKey(res) && hm.get(res) != i) {
                ans[0] = i;           // index of first number
                ans[1] = hm.get(res); // index of the matching number
                break;
            }
        }

        return ans;
    }
}
