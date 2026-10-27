
class Solution {

    // Prev Smaller ele Index 
    // indexx push kele ahet
    public static int[] getPSE(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return result;
    }

    // NEXT Smaller Element
    // index push kele ahet
    public static int[] getNSE(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            result[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return result;
    }



    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        // Store in that
        int[] PSE = getPSE(arr, n);
        int[] NSE = getNSE(arr, n);

        long sum = 0;
        int M = 1000000007;
        for (int i = 0; i < n; i++) {
            // curr index minus PSE index of that curr index
            // tyalmul tya ele cha left la kiti small element ahet te smjat
            // 5-2=3 means left la 3 elements jyancha min i ahe

            long left = i - PSE[i];

            long right = NSE[i] - i;


            long totalSubarrays = left * right;

            long contribution = (long) arr[i] * totalSubarrays; // 12 subarray * min of that subarray means (addition os that subarray min sum)

            sum = (sum + contribution) % M; 
        }

        return (int) sum;
    }
}
