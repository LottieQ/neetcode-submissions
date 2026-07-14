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
    public ListNode mergeKLists(ListNode[] lists) {
        if ( lists== null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a , b) -> Integer.compare(a.val, b.val));
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for(ListNode list: lists){
            if(list != null){pq.offer(list);}
        }

        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;

            if(min.next != null){
                pq.offer(min.next);
            }
        }
        return dummy.next;

    }
}
