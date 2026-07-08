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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroup = dummy;
        
        while(true){
            ListNode nextGroup = prevGroup;
            for(int i = 0; i < k; i++){
                if(nextGroup == null){
                    break;
                }
                nextGroup = nextGroup.next;
            }

            if(nextGroup == null) break;
            
            nextGroup = nextGroup.next;
            ListNode prev = nextGroup;
            ListNode curr = prevGroup.next;
            ListNode mark = curr;
            while(curr != nextGroup){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            prevGroup.next = prev;
            prevGroup = mark;
        }

        return dummy.next;
    }
}
