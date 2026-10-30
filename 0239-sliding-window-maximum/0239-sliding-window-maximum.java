class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int ans[]=new int[n-k+1];

        Deque<Integer> dqe=new ArrayDeque<>();
        int index=0;
        for(int i=0;i<n;i++){

            while(!dqe.isEmpty() && dqe.peekFirst() <= i-k){
                dqe.pollFirst();
            }

            while(!dqe.isEmpty() && nums[i] > nums[dqe.peekLast()]){
                dqe.pollLast();
            }

            dqe.offerLast(i);
            
            if(i>=k-1){
                ans[index++]=nums[dqe.peekFirst()];
            }
        }
        return ans;
    }
}