import java.util.*;

class Solution {
    public int numberOfSubstrings(String s) {
        int[] lastseen = new int[3];
        Arrays.fill(lastseen, -1);
        int res = 0;

        for (int right = 0; right < s.length(); right++) {
            lastseen[s.charAt(right) - 'a'] = right;

            if (lastseen[0] != -1 && lastseen[1] != -1 && lastseen[2] != -1) {
                res += Math.min(Math.min(lastseen[0], lastseen[1]), lastseen[2]) + 1;
            }
        }

        return res;
    }
}
