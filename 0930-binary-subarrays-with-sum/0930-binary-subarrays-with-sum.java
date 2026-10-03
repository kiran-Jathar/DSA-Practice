class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        // sum-k == present in map  ==> its perfect subarrray

        HashMap<Integer,Integer> map=new HashMap<>();

        map.put(0,1);
        int sum=0;
        int ans=0;

        for(int ele:nums){

            sum+=ele;

            if(map.containsKey(sum-goal)){
                ans+=map.get(sum-goal);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}