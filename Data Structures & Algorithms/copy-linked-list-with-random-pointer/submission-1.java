/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Integer> map = new HashMap<>();
        Node dummy = new Node(0);
        Node currCopy = dummy;
        List<Node> list = new LinkedList<>();
        Node curr = head;
        int idx = 0;

        while(curr != null){
            Node newNode  = new Node(curr.val);
            currCopy.next = newNode;
            list.add(newNode);
            map.put(curr, idx);
            curr = curr.next;
            currCopy = currCopy.next;
            idx++;
        }

        curr = head;
        currCopy = dummy.next;
        while(curr != null){
            if(curr.random == null){
                currCopy.random = null;    
            }else{
                idx = map.get(curr.random);
                currCopy.random = list.get(idx); 
            } 
            curr = curr.next;
            currCopy = currCopy.next;         
        }

        return dummy.next;
    }
}
