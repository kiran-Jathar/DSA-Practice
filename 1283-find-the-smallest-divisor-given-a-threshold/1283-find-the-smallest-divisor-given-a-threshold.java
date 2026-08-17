class Solution {

    public int isPossible(int[] nums, int threshold, int divisor) {

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] + divisor - 1) / divisor;
        }

        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {

        int low = 1;
        int high = 0;

        for (int i = 0; i < nums.length; i++) {
            high = Math.max(high, nums[i]);
        }

        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int sum = isPossible(nums, threshold, mid);

            if (sum <= threshold) {

                ans = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        return ans;
    }
}