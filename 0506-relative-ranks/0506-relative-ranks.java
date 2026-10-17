class Solution {
    public String[] findRelativeRanks(int[] score) {

        int n = score.length;
        String[] ans = new String[n];

        Integer[] index = new Integer[n];

        // Store original indices
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        for (int i = 0; i < n; i++) {
            int maxIndex = i;

            // Find the highest score among remaining indices
            for (int j = i + 1; j < n; j++) {
                if (score[index[j]] > score[index[maxIndex]]) {
                    maxIndex = j;
                }
            }

            // Swap indices, not scores
            int temp = index[i];
            index[i] = index[maxIndex];
            index[maxIndex] = temp;

            // Store rank at the original index
            int originalIndex = index[i];

            if (i == 0) {
                ans[originalIndex] = "Gold Medal";
            } else if (i == 1) {
                ans[originalIndex] = "Silver Medal";
            } else if (i == 2) {
                ans[originalIndex] = "Bronze Medal";
            } else {
                ans[originalIndex] = String.valueOf(i + 1);
            }
        }

        return ans;
    }
}