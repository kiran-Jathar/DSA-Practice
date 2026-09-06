class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        if(n==1)return 0;

        while(low<=high){
            boolean leftFlag=false;
            boolean rightFlag=false;

            int mid=low+(high-low)/2;
            
            if(mid==0 || nums[mid]>nums[mid-1] ){
                leftFlag=true;
            }

            if(mid==n-1 || nums[mid]>nums[mid+1]){
                rightFlag=true;
            }


            if(leftFlag && rightFlag){
                return mid;
            }
            else if(nums[mid]<nums[mid+1]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
}