class Solution {
    public String removeDuplicates(String s) {
    
        Stack<Character> st=new Stack<>();

        StringBuffer str=new StringBuffer();

        char arr[]=s.toCharArray();

        for(char ele : arr){

            if(!st.isEmpty() && st.peek()==ele){
                st.pop();
            }
            else{
                st.push(ele);
            }
        }

        for(char ele: st){
            str.append(ele);
        }
        return str.toString();
    }
}