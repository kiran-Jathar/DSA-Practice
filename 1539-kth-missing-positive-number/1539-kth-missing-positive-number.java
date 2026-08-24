class Solution {
    public int findKthPositive(int[] arr, int k) {

        for(int i = 0; i < arr.length; i++) {

            int missing = arr[i] - (i + 1);

            if(missing >= k) {
                return k + i;
            }
        }

        return k + arr.length;
    }
}