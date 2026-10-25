import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        // Use Deque as a stack to store surviving asteroids
        Deque<Integer> st = new ArrayDeque<>();

        // Process each asteroid one by one
        for (int a : asteroids) {

            // Collision is possible only when:
            // 1. Stack is not empty
            // 2. Current asteroid moves left (negative)
            // 3. Stack's top asteroid moves right (positive)
            while (!st.isEmpty() && a < 0 && st.peek() > 0) {

                // Add sizes with their signs to determine the winner
                int sum = a + st.peek();

                if (sum < 0) {
                    // Current negative asteroid is bigger
                    // Destroy the stack's top asteroid
                    st.pop();

                    // Continue checking for another possible collision
                } 
                else if (sum > 0) {
                    // Stack's top asteroid is bigger
                    // Current asteroid is destroyed
                    a = 0;
                    break;
                } 
                else {
                    // Both asteroids have equal size
                    // Destroy the stack's top asteroid
                    st.pop();

                    // Mark current asteroid as destroyed too
                    a = 0;
                }
            }

            // Push the current asteroid only if it survived
            if (a != 0) {
                st.push(a);
            }
        }

        // Create the result array containing surviving asteroids
        int[] ans = new int[st.size()];

        // Stack pops from top to bottom.
        // Fill the array backwards to preserve the original order.
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        // Return the surviving asteroids
        return ans;
    }
}