/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        
        while(fast != null){
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        ListNode next = slow.next;
        if(prev != null){
            prev.next = next;
            slow.next = null;
        }else{
            head = next;
        }

        return head;
    }
}
