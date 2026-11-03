class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += cardPoints[i];
        }

        int low = 0;
        int high = n - 1;

        int leftsum = 0;

        // Initially select k cards from left
        for (int i = 0; i < k; i++) {
            leftsum += cardPoints[i];
        }

        int maxSum = leftsum;

        // Replace left cards with right cards
        while (low < k) {

            leftsum -= cardPoints[k - 1 - low];

            leftsum += cardPoints[high];

            high--;
            low++;

            maxSum = Math.max(maxSum, leftsum);
        }

        return maxSum;
    }
}