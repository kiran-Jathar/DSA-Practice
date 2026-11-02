class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deq=new ArrayDeque<>();
        int n=nums.length;
        int j=0;

        int ans[]=new int[n-k+1];

        for(int i=0;i<n;i++){
            
            // size==k then shrink
            while(!deq.isEmpty() && deq.peekFirst() <= i-k){
                deq.pollFirst();
            }

            // mono desc
            while(!deq.isEmpty() && nums[i] >= nums[deq.peekLast()]){
                deq.pollLast();
            }
            deq.offerLast(i);

            if(i>=k-1){
                ans[j]=nums[deq.peekFirst()];
                j++;
            }
        } 
        return ans;
    }
}