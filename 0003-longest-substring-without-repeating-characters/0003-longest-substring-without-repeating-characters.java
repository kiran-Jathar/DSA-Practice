class Solution {
    public int lengthOfLongestSubstring(String s) {
        int low=0;
        int high=0;
        int n=s.length();
        int ans=0;

        HashSet<Character> set=new HashSet<>();

        while(high<n){

            while(set.contains(s.charAt(high))){
                set.remove(s.charAt(low));
                low++;
            }

            set.add(s.charAt(high));

            ans=Math.max(ans,(high-low+1));
            high++;
        }
        return ans;
    }
}