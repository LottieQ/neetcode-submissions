class LRUCache {

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        insertToFront(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node old = map.get(key);
            remove(old);
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insertToFront(newNode);

        if(map.size() > capacity){
            Node removeNode = tail.prev;
            remove(removeNode);
            map.remove(removeNode.key);
        }
    }

    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToFront(Node node){
        Node next = head.next;
        
        head.next = node;
        node.prev = head;

        next.prev = node;
        node.next = next;
    }
}
