class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a , b) -> Integer.compare(b , a));

        for(int stone : stones){
            maxheap.offer(stone);
        }

        while(maxheap.size() > 1){
            int stone1 = maxheap.poll();
            int stone2 = maxheap.poll();

            int diff = Math.abs(stone1 - stone2);
            if(diff > 0){
                maxheap.offer(diff);
            }
        }

        return maxheap.isEmpty() ? 0 : maxheap.poll();
    }
}
