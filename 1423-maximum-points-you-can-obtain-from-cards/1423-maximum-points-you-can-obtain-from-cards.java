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
        while (low < k) {
            leftsum += cardPoints[low];
            low++;
        }
        // low k var asnar

        int maxSum = leftsum;

        low = k - 1;
        // low 3-1=2
        
        // low = 0 1 2 

        while (low >= 0) {

            leftsum -= cardPoints[low];

            leftsum += cardPoints[high];

            high--;
            low--;

            maxSum = Math.max(maxSum, leftsum);
        }

        return maxSum;
    }
}