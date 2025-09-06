import java.util.*;

class Solution {
    public String frequencySort(String s) {
        // Step 1: Count frequency of ASCII characters
        int[] freq = new int[123]; // ASCII codes 0 to 122
        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }

        // Step 2: Create a list of pairs (char, frequency)
        List<int[]> vec = new ArrayList<>();
        for (int i = 0; i <= 122; i++) {
            if (freq[i] > 0) {
                vec.add(new int[]{i, freq[i]}); // [charCode, frequency]
            }
        }

        // Step 3: Sort by frequency descending
        vec.sort((a, b) -> b[1] - a[1]);

        // Step 4: Build result string
        StringBuilder result = new StringBuilder();
        for (int[] p : vec) {
            char ch = (char)p[0];
            int count = p[1];
            for (int i = 0; i < count; i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
