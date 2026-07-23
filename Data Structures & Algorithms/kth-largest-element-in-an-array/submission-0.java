class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num: nums){
            int curr = num;
            if(pq.size() == k){
                curr = Math.max(pq.poll(), curr);
            }

            pq.offer(curr);
        }

        return pq.peek();
    }
}
