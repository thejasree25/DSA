class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxEnding = nums[0]; // max subarray sum ending at current index
        int res = nums[0];       // overall max subarray sum

        for (int i = 1; i < n; i++) {
            // extend previous subarray or start new from nums[i]
            maxEnding = Math.max(maxEnding + nums[i], nums[i]);
            // update overall result
            res = Math.max(res, maxEnding);
        }
        return res;
    }
}
