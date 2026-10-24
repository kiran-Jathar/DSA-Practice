import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> st = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < asteroids.length; i++) {
            int ele = asteroids[i];

            // Negative asteroid
            if (ele < 0) {
                int n = Math.abs(ele);
                boolean isDestroyed = false;

                while (!st.isEmpty() && st.peek() > 0 && st.peek() <= n) {

                    if (st.peek() == n) {
                        st.pop();
                        isDestroyed = true;
                        break;
                    }

                    st.pop();
                }

                if (!st.isEmpty() && st.peek() > 0) {
                    isDestroyed = true;
                }

                if (!isDestroyed) {
                    st.push(ele);
                }
            } 
            else {
                // Positive asteroid
                st.push(ele);
            }
        }

        int[] ans = new int[st.size()];

        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }
}