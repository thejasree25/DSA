class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle k > n
        if (k == 0) return;

        // Step 1: Save last k elements into temp
        int[] temp = new int[k];
        for (int i = n - k; i < n; i++) {
            temp[i - (n - k)] = nums[i];
        }

        // Step 2: Shift first n-k elements to the right by k positions
        for (int i = n - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }

        // Step 3: Copy temp elements to the first k positions
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }
}
