class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int l = 0, count = 0, sum = 0;

        for (int r = 0; r < nums.length; r++) {
            sum += nums[r] % 2;   // add 1 if odd, else 0

            while (sum > k) {
                sum -= nums[l] % 2;
                l++;
            }

            count += (r - l + 1);
        }
        return count;
    }
}
