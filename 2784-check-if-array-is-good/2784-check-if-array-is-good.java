class Solution {
    public boolean isGood(int[] nums) {

        
        int n=nums.length;
        Arrays.sort(nums);

        int maxi=nums[n-1];

        if(maxi+1 != nums.length){
            return false;
        }
        int count=0;


        for(int i=1;i<n-1;i++){
            if(nums[i]==nums[i-1]){
                return false;
            }
        }

        for(int i=0;i<n;i++){
            if(nums[i]==maxi){
                count++;
            }
            if(count==2)return true;
        }
        return false;
    }
}