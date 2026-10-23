class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int flag=0;
        int ans[]=new int[n];
        Arrays.fill(ans,-1);

        for(int i=0;i<n;i++){

            for(int j=1;j<=n;j++){

                if(nums[(j+i) % n]>nums[i]){

                    ans[i]=nums[(j+i) % n];
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                ans[i]=-1;
            }
        }
        return ans;
    }
}