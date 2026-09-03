class Solution {
    public void moveZeroes(int[] nums) {
        int low=0;
        int high;

        for(high=0;high<nums.length;high++){

            if(nums[high]!=0){
                nums[low]=nums[high];
                low++;
            }
        }
        if(low<nums.length){
            for(int i=low;i<nums.length;i++){
                nums[i]=0;
            }
        }
    }
}