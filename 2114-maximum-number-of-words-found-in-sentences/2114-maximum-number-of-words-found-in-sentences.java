class Solution {
    public int mostWordsFound(String[] sentences) {
        int n=sentences.length;
        int ans=0;

        for(int i=0;i<n;i++){
            String str=sentences[i];
            String arr[]=str.split("\\s+");

            if(ans<arr.length){
                ans=arr.length;
            }    
        }

        return ans;
    }
}