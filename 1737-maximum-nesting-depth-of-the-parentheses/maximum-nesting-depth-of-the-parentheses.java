import java.util.*;

class Solution {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
        int result = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                st.push(ch);
                result = Math.max(result, st.size());
            } else if (ch == ')') {
                if (!st.isEmpty()) {
                    st.pop();
                }
            }
        }

        return result;
    }
}
