class Solution { 
    public double findMaxAverage(int[] nums, int k) { 
        int n = nums.length; 
        int low = 0; 
        int high = 0; 
        // Changed to MIN_VALUE to handle negative numbers correctly
        int ans = Integer.MIN_VALUE; 
        int sum = 0; 

        while (high < n) { 
            sum += nums[high]; 

            if ((high - low) + 1 < k) { 
                high++; 
            } 
            else if ((high - low) + 1 == k) { 
                if (sum > ans) { 
                    ans = sum; 
                } 
                sum -= nums[low]; 
                low++; 
                high++; // 💡 FIX: Move the right pointer forward to check the next window
            } 
        } 
        return (double) ans / k; 
    } 
}
