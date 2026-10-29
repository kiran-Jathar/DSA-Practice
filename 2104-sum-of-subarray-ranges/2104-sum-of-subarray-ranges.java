import java.util.*;

public class Solution {
    
    // Previous Smaller Index
    public static int[] getPSI(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int[] PSI = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            PSI[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return PSI;
    }

    // Previous Greater Index
    public static int[] getPGI(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int[] PGI = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            PGI[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return PGI;
    }

    // Next Smaller Index
    public static int[] getNSI(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int[] NSI = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            NSI[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return NSI;
    }

    // Next Greater Index
    public static int[] getNGI(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int[] NGI = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            NGI[i] = st.isEmpty() ? n : st.peek();
            
            st.push(i);
        }
        return NGI;
    }

    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[] PSI = getPSI(nums, n);
        int[] PGI = getPGI(nums, n);
        int[] NSI = getNSI(nums, n);
        int[] NGI = getNGI(nums, n);

         System.out.print(Arrays.toString(PSI)); 
         System.out.print(Arrays.toString(NSI)); 
         System.out.print(Arrays.toString(PGI)); 
         System.out.print(Arrays.toString(NGI));

        long totalSum  = 0;

        for (int i = 0; i < n; i++) {
            // 1. Number of subarrays where nums[i] is maximum
            long maxCount = (long)(i - PGI[i]) * (NGI[i] - i);

            // 2. Number of subarrays where nums[i] is minimum
            long minCount = (long)(i - PSI[i]) * (NSI[i] - i);

            // 3. Maximum contribution
            long maxContribution = nums[i] * maxCount;

            // 4. Minimum contribution
            long minContribution = nums[i] * minCount;

            // 5. Calculate net contribution
            long contribution = maxContribution - minContribution;

            // 6. Add to total sum
            totalSum += contribution;
        }

        return totalSum;
    }
}
