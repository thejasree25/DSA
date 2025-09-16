import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];

        // push the last index
        st.push(n - 1);

        // iterate from right to left
        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty()) {
                int top = st.peek();
                if (temperatures[i] > temperatures[top]) {
                    st.pop(); // remove colder days
                } else if (temperatures[i] < temperatures[top]) {
                    ans[i] = top - i; // next warmer day found
                    break;
                } else {
                    st.pop(); // same temperature, remove
                }
            }
            st.push(i);
        }

        return ans;
    }
}
