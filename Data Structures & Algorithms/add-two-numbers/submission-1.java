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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int add = 0;

        while(l1 != null || l2 != null){
            int num1 = (l1 == null ? 0 : l1.val);
            int num2 = (l2 == null ? 0 : l2.val);
            curr.next = new ListNode((num1 + num2 + add) % 10);
            add = (num1 + num2 + add) / 10;
            curr = curr.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        if(add != 0){
            curr.next = new ListNode(add);
        }

        return dummy.next;
    }
}
