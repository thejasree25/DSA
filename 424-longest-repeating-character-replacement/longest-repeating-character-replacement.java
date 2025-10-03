class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        int maxlength = 0;
        int maxfreq = 0;
        int[] hash = new int[26];

        while (right < s.length()) {
            hash[s.charAt(right) - 'A']++;
            maxfreq = Math.max(maxfreq, hash[s.charAt(right) - 'A']);

            while ((right - left + 1) - maxfreq > k) {
                hash[s.charAt(left) - 'A']--;
                left++;
                
                // recalculate maxfreq (optional optimization: can skip for O(1) version)
                maxfreq = 0;
                for (int i = 0; i < 26; i++) {
                    maxfreq = Math.max(maxfreq, hash[i]);
                }
            }

            maxlength = Math.max(maxlength, right - left + 1);
            right++;
        }

        return maxlength;
    }
}
