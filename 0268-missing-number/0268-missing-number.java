class Solution {
    public int missingNumber(int[] nums) {
        
        int n=nums.length;

        int expSum=n*(n+1)/2;
        
        int actualSum = Arrays.stream(nums).sum();

        return expSum-actualSum;

    }
}