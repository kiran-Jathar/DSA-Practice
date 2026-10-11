/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

        ListNode slow=head;
        ListNode fast=head;
        boolean hasCycle=false;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;

            if(fast==slow){
                fast=head;
                hasCycle=true;
                break;
            }
        }   

        if(hasCycle==false){
            return null;
        }
        
        while(fast!=slow){
            slow=slow.next;
            fast=fast.next;
        }

        if(slow==fast){
            return slow;
        }
        
        return null;
    }
}