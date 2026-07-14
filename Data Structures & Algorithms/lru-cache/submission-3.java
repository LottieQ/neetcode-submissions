class LRUCache {
    int capacity;
    Map<Integer, Node> keyMap;
    Map<Integer, Integer> map;
    Node head;
    Node tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        keyMap = new HashMap<>();
        map = new HashMap<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node curr = keyMap.get(key);
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            Node temp = head.next;
            head.next = curr;
            curr.prev = head;
            curr.next = temp;
            temp.prev = curr;
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            Node newNode = new Node(key);
            map.put(key, value);
            keyMap.put(key, newNode);
            Node temp = head.next;
            head.next = newNode;
            newNode.prev = head;
            newNode.next = temp;
            temp.prev = newNode;
        }else{
            Node curr = keyMap.get(key);
            map.put(key, value);
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            Node temp = head.next;
            head.next = curr;
            curr.prev = head;
            curr.next = temp;
            temp.prev = curr;
        }
        if(map.size() > capacity){
            Node remove = tail.prev;
            map.remove(remove.val);
            keyMap.remove(remove.val);
            Node temp = remove.prev;
            temp.next = tail;
            tail.prev = temp;
            remove.next = null;
            remove.prev = null;
        }
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;

    public Node(int val){
        this.val = val;
        prev = null;
        next = null;
    }
}
