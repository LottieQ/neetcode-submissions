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
    public void reorderList(ListNode head) {        
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode curr = null;
        if(fast == null){
            curr = slow;
        }else{
            curr = slow.next;
        }
        
        ListNode mid = null;
        
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = mid;
            mid = curr;
            curr = temp;
        }

        curr = head;
        while(mid != null){
            ListNode temp1 = curr.next;
            ListNode temp2 = mid.next;

            curr.next = mid;
            curr = temp1;
            mid.next = curr;
            mid = temp2;
        }

        curr.next = mid;
        return;
    }
}
