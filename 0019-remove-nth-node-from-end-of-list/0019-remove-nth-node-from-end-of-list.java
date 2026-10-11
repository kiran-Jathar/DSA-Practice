class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        int length = 1; 
        ListNode trav = head;
        
        while (trav != null) {
            length++; 
            trav = trav.next;
        }

        if (n == length - 1) { // because n=3 asle ans len pn 3 asen tr 3-3=0 head delete karaycha ahe tya sathi
            return head.next;
        }

        int k = (length - n); 
        
        trav = head;
        for (int i = 1; i < k - 1 && trav != null; i++) {
            trav = trav.next;
        }
        
       if (trav != null && trav.next != null) {  // for safety
            trav.next = trav.next.next;
        }

        return head;
    }
}
