/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long low=1;
        long high=n;
        long store=0;

        while(low<=high){
            long mid=(int)low+(high-low)/2;

            if(isBadVersion((int)mid)==true){
                store=mid;
                high=mid-1;
            }
            else if(isBadVersion((int)mid)==false){
                low=mid+1;
            }            
        }
        return (int) store;
    }
}