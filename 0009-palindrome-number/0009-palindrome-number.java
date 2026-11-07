class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
        {
            return false;
        }
        int revnum=0;
        int temp=x;

        while(temp!=0)
        {
            int digit=temp%10;
            revnum=(revnum*10)+digit;
            temp=temp/10;
        }
        if(revnum==x)
        {
            return true;
        }
        else
        {
            return false;
        }
    
    }
}