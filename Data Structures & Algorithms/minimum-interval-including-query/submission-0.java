class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] sortedQueries = queries.clone();
        Arrays.sort(sortedQueries);

        //key: query value: length
        Map<Integer, Integer> map = new HashMap<>();

        //int[0] = length; int[1] = end;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a , b) -> Integer.compare(a[0], b[0])
        );

        int i = 0;

        for(int query: sortedQueries){
            while(i < intervals.length && intervals[i][0] <= query){
                int start = intervals[i][0];
                int end = intervals[i][1];
                int length = end - start + 1;

                minHeap.offer(new int[]{length, end});
                i++;
            }

            while(!minHeap.isEmpty() && minHeap.peek()[1] < query){
                minHeap.poll();
            }

            if(minHeap.isEmpty()){
                map.put(query, -1);
            }else{
                map.put(query, minHeap.peek()[0]);
            }
        }

        int[] answer = new int[queries.length];

        for(int j = 0; j < queries.length; j++){
            answer[j] = map.get(queries[j]);
        }

        return answer;
    }
}
