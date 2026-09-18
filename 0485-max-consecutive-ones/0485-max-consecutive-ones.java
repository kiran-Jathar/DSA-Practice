class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int low=0;
        int high=0;
        int n=nums.length;
        int max=0;

        while(high<n){
            if(nums[high]==1){
                high++;
            }
            else{
                if(max<(high-low)){
                    max=high-low;
                }
                high++;
                low=high;
            }
        }
        max = Math.max(max, high - low);
        return max;
    }
}