class Solution {
    public int majorityElement(int[] nums) {
        int low=0;
        int high=0;
        int n=nums.length;
        Arrays.sort(nums);
        int count=0;

        while(high<n){
            if(nums[low] ==nums[high]){
                count++;
            }
            else{
                if(count> (n/2)){
                    return nums[low];
                }
                low=high;
                count=1;
            }
            high++;
        }

        if(count>=(n/2)){
            return nums[low];
        }
        return -1;
    }
}