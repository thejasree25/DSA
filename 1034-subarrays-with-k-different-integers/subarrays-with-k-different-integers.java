import java.util.*;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return func(nums, k) - func(nums, k - 1);
    }

    private int func(int[] nums, int k) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int l = 0, r = 0, count = 0, n = nums.length;

        while (r < n) {
            mpp.put(nums[r], mpp.getOrDefault(nums[r], 0) + 1);

            while (mpp.size() > k) {
                mpp.put(nums[l], mpp.get(nums[l]) - 1);
                if (mpp.get(nums[l]) == 0) {
                    mpp.remove(nums[l]);
                }
                l++;
            }

            count += (r - l + 1);
            r++;
        }
        return count;
    }
}
