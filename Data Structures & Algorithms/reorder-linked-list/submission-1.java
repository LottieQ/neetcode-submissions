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

        while(fast != null && fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode prev = slow.next;
        slow.next = null;
        ListNode curr = null;
        
        while(prev != null){
            ListNode temp = prev.next;
            prev.next = curr;
            curr = prev;
            prev = temp;
        }

        ListNode right = curr;
        ListNode left = head;

        curr = head;
        while(right != null){
            left = left.next;
            curr.next = right;
            right = right.next;
            curr = curr.next;

            curr.next = left;
            curr = curr.next;
        }

        if(right != null){
            curr.next = right;
        }
    }
}
