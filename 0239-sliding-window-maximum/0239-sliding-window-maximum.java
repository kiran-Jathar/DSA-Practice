class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int ans[]=new int[n-k+1];

        Deque<Integer> dqe=new ArrayDeque<>();
        int index=0;
        for(int i=0;i<n;i++){
    
            // jr window size ==k zali tr first ele remove karun window shrink kelii.. new ele add krayla

            while(!dqe.isEmpty() && dqe.peekFirst() <= i-k){
                dqe.pollFirst();
            }

            // jr ele > asel peeklast peksha tr dqe madhale ele remove karayche 
            // to maintain the monotonic order

            while(!dqe.isEmpty() && nums[i] > nums[dqe.peekLast()]){
                dqe.pollLast();
            }


            dqe.offerLast(i);
            
            // je size ==k asel tr peekFirst ha max asnar to ans madhe add karaycha
            if(i>=k-1){
                ans[index++]=nums[dqe.peekFirst()];
            }
        }
        return ans;
    }
}