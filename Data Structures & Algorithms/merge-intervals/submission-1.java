class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        for(int[] interval : intervals){
            pq.offer(interval);
        }

        int currStart = -1, currEnd = -1;

        while(!pq.isEmpty()){
            int[] interval = pq.poll();
            if(interval[0] > currEnd){
                ans.add(new int[]{currStart, currEnd});
                currStart = interval[0];
                currEnd = interval[1];
            }else{
                currStart = Math.min(currStart, interval[0]);
                currEnd = Math.max(currEnd, interval[1]);
            }
        }

        ans.add(new int[]{currStart, currEnd});

        int[][] result = new int[ans.size() - 1][2];
        for(int i = 1; i < ans.size(); i++){
            result[i - 1] = ans.get(i);
        }

        return result;
    }
}
