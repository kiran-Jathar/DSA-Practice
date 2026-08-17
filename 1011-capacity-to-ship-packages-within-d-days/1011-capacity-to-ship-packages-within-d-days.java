class Solution {

    public int isPossible(int weights[],int days,int capacity){
        int n=weights.length;
        int sum=0;
        int day=1;

        for(int i=0;i<n;i++){
            sum+=weights[i];

            if(sum>capacity){
                day++;
                sum=weights[i];
            }
        }
        return day;
    }

    public int shipWithinDays(int[] weights, int days) {
        
        int maxi=Integer.MIN_VALUE;

        int sum=0;

        for(int i=0;i<weights.length;i++){
            maxi=Math.max(maxi,weights[i]);

            sum+=weights[i];
        }

        int low=maxi;
        int high=sum;
        int result=0;

        while(low<=high){
            int mid=(low+high)/2;
            
            int ans=isPossible(weights, days, mid);


            if(ans<=days){
                result =mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return result;
    }
}