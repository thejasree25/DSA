class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            int value = nums[i];
            if (hm.get(value) > 1) {
                return true;
            }
        }
        return false;
    }
}
