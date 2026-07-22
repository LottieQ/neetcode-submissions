class KthLargest {

    private PriorityQueue<Integer> pq;
    private int size;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        size = k;

        for(int num : nums){
            pq.offer(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        if(pq.size() == size){
            if(val > pq.peek()){
                pq.offer(val);
                pq.poll();
            }
        }else{
            pq.offer(val);
        }

        return pq.peek();
    }
}
