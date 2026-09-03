class Solution {
    public int removeDuplicates(int[] nums) {
        int low=0;
        int high=0;
        int n=nums.length;

        while(high<n){

            if(nums[low]!=nums[high]){
                low++;
                nums[low]=nums[high];
            }
            high++;
        }
        return low+1;
    }
}