class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int lowA = 0;
        int lowB = 0;

        while (lowA < m && lowB < n) {

            if (nums1[lowA] <= nums2[lowB]) {
                lowA++;
            }
            else {
                // Swap
                int temp = nums1[lowA];
                nums1[lowA] = nums2[lowB];
                nums2[lowB] = temp;

                lowA++;

                // Maintain nums2 sorted
                int j = lowB;

                while (j + 1 < n && nums2[j] > nums2[j + 1]) {
                    int t = nums2[j];
                    nums2[j] = nums2[j + 1];
                    nums2[j + 1] = t;
                    j++;
                }
            }
        }

        // Copy remaining nums2
        while (lowB < n) {
            nums1[m] = nums2[lowB];
            lowB++;
            m++;
        }
    }
}