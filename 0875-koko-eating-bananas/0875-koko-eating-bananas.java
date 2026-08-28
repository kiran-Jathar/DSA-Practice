class Solution {

    public boolean isPossible(int[] piles, int h, int k) {

        long hours = 0;

        for(int i = 0; i < piles.length; i++) {
            hours += Math.ceil((double)piles[i] / k);
        }

        return hours <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = 0;

        for(int i = 0; i < piles.length; i++) {
            high = Math.max(high, piles[i]);
        }

        while(low <= high) {

            int mid = low + (high - low) / 2;

            if(isPossible(piles, h, mid)) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }
}