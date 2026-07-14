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
        if(k == 1) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode setBefore = dummy;
        ListNode prev, curr;
        while(setBefore != null){
            ListNode nextSetBefore = setBefore.next;
            ListNode nextNextSetBofore = nextSetBefore;
            for(int i = 0; i < k; i++){
                if(nextNextSetBofore == null) return dummy.next;
                nextNextSetBofore = nextNextSetBofore.next;
            }
            prev = nextSetBefore;
            curr = nextSetBefore.next;
            for(int i = 0; i < k - 1; i++){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            setBefore.next = prev;
            nextSetBefore.next = nextNextSetBofore;
            setBefore = nextSetBefore;
            nextSetBefore = nextNextSetBofore;
        }
        return dummy.next;
    }
}
