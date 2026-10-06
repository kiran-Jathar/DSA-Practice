class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> posNums=new ArrayList<>();
        ArrayList<Integer> negNums=new ArrayList<>();

        for(int ele : nums){
            if(ele<0){
                negNums.add(ele);
            }
            else if(ele>0){
                posNums.add(ele);
            }
        }

        int ans[]=new int[nums.length];
        
        int j=0;
        for(int i=0;i<nums.length;i++){
            ans[i]=posNums.get(j);
            i++;
            ans[i]=negNums.get(j);
            j++;
        }
        return ans;

    }
}