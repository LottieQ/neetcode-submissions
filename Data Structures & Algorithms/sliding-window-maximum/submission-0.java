class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a , b) -> Integer.compare(b[0], a[0])
        );
        int[] ans = new int[nums.length - k + 1];
        for(int i = 0; i < k; i++){
            maxHeap.offer(new int[]{nums[i], i});
        }
        ans[0] = maxHeap.peek()[0];

        int l = 0;
        for(int r = k; r < nums.length; r++){
            maxHeap.offer(new int[]{nums[r], r});
            while(maxHeap.peek()[1] < r - k + 1){
                maxHeap.poll();
            }
            ans[r - k + 1] = maxHeap.peek()[0];
        }

        return ans;
    }
}
