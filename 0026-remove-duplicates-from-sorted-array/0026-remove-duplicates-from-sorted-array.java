class Solution {
    public int removeDuplicates(int[] nums) {
          // same direction two pointer


          int low=0;
          int high=0;
          int n=nums.length;

        while(high<n) {
            if(nums[low]==nums[high]){
                high++;
            }
            else if(nums[low]!=nums[high]){
                low++;
                nums[low]=nums[high];
            }
          }
        return low+1;
    }
}