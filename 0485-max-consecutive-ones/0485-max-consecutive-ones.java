class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int low = 0;
        int high = 0;
        int n = nums.length;
        int max = 0;

        while (high < n) {
            if (nums[high] == 1) {
                high++;
            } else {
                max = Math.max(max, high - low);
                
                // Move high past the 0, and reset low to match high
                high++;
                low = high;
            }
        }
        
        // CRUCIAL FIX: If the array ends with a 1, the else block never runs for that last streak.
        // We must check the length of the final streak after the loop finishes.
        max = Math.max(max, high - low);

        return max;
    }
}
