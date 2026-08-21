class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        int maxPile = 0;

        for (int x : piles) {
            maxPile = Math.max(maxPile, x);
        }
        
        int low=1;
        int high=maxPile;
        int ans=0;

        while(low<=high) {

            int mid=low+(high-low)/2;
            long hour=0;
            
            for (int j = 0; j < piles.length; j++) {

                hour += (long) Math.ceil((double) piles[j] / mid);  
            } 

            if (hour <= h) {
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        return low;
    }
}