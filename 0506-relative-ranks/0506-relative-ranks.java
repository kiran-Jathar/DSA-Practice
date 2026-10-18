import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        String[] ans = new String[n];

        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        // Sort the scores in descending order
        Arrays.sort(arr);

        int rank = 1;

        for(int j = n - 1; j >= 0; j--) {
            int originalIndex = map.get(arr[j]);

            if (rank == 1) {
                ans[originalIndex] = "Gold Medal";
            } else if (rank == 2) {
                ans[originalIndex] = "Silver Medal";
            } else if (rank == 3) {
                ans[originalIndex] = "Bronze Medal";
            } else {
                ans[originalIndex] = String.valueOf(rank);
            }

            rank++;
        }

        return ans;
    }
}