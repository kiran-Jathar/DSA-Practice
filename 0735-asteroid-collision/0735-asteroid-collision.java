import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Deque<Integer> st = new ArrayDeque<>();

        for (int ele : asteroids) {

            boolean isDestroy = false;

            while (!st.isEmpty() && ele < 0 && st.peek() > 0) {

                int sum = ele + st.peek();

                if (sum < 0) {
                    // Current negative asteroid is bigger
                    st.pop();
                }
                else if (sum > 0) {
                    // Stack top is bigger
                    isDestroy = true;
                    break;
                }
                else if(sum==0) {
                    // Both asteroids are destroyed
                    st.pop();
                    isDestroy = true;
                    break;
                }
            }

            // Push only if current asteroid survived
            if (isDestroy==false) {
                st.push(ele);
            }
        }

        int[] ans = new int[st.size()];

        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }
}