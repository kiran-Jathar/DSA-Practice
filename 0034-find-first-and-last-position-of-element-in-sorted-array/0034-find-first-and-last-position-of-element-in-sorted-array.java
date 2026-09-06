class Solution {

    int firstPosition(int nums[], int target){
        int n=nums.length;
        int store=-1;
        int low=0;
        int high=n-1;

        while(low<=high){
            int mid=low +(high-low)/2;

            if(nums[mid]==target){
                store=mid;
                high=mid-1;
            }
            else if (target<nums[mid]){
                high=mid-1;
            }
            else if(target>nums[mid]){
                low=mid+1;
            }
        }
        return store;

    }

    int lastPosition(int nums[],int target){
        int store=-1;
        int n=nums.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid]==target){
                store=mid;
                low=mid+1;
            }
            else if(target>nums[mid]){
                low=mid+1;
            }
            else if(target<nums[mid]){
                high=mid-1;
            }
        }
        return store;
    }

    public int[] searchRange(int[] nums, int target) {

        int f=firstPosition(nums,target);
        int l=lastPosition(nums,target);

        return new int[]{f,l};
    }
}