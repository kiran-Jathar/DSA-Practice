class Solution {
    public int minimumSwaps(int[] nums) {
        int low=0;
        int high=nums.length-1;
        int count=0;

        while(low<=high){

            if(nums[low]==0){
                if(nums[high]!=0){
                    int temp=nums[low];
                    nums[low]=nums[high];
                    nums[high]=temp;

                    count++;
                    low++;
                    high--;
                }
                else if(nums[high]==0){
                    high--;
                }  
            }
            else{
                low++;
            }
        }
        return count;
    
    }
}