class Solution {

    public String reverseVowels(String str) {

        StringBuffer s = new StringBuffer(str);

        int low = 0;
        int high = s.length() - 1;

        while (low < high) {

            if (!isVowel(s.charAt(low))) {
                low++;
            }
            else if (!isVowel(s.charAt(high))) {
                high--;
            }
            else {
                // Both are vowels → swap
                char temp = s.charAt(low);
                s.setCharAt(low, s.charAt(high));
                s.setCharAt(high, temp);

                low++;
                high--;
            }
        }

        return s.toString();
    }

    public boolean isVowel(char ch) {

        ch = Character.toLowerCase(ch);

        return ch == 'a' || ch == 'e' || ch == 'i'
            || ch == 'o' || ch == 'u';
    }
}