class Solution {
    public boolean validPalindrome(String s) {
        int i=0, e=s.length()-1;
                        
        while(i<e) {
            if(s.charAt(i)==s.charAt(e)) {
                i++;
                e--;
            }else {
                break;
            }
        }
        if(i>=e) {
            return true; 
        }
        if(!Palindrome(i,e-1, s)) { 
            return Palindrome(i+1,e, s); 
        }
        return true; 
    }
    
    private boolean Palindrome(int i, int e, String s) {

        while(i<e) {
            if(s.charAt(i)==s.charAt(e)) {
                i++;
                e--;
            }else {
                return false;
            }
        }
        return true;
    }
}
 

