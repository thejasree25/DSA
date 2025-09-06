import java.util.*;

class Solution {
    public int maxDepth(String s) {
        int result = 0;
        int openBrackets = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                openBrackets++;
                result = Math.max(result, openBrackets); // update max depth here
            } else if (ch == ')') {
                openBrackets--;
            }
        }

        return result;
    }
}
