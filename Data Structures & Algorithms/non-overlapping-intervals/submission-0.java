class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 0;
        int currEnd = intervals[0][1];

        for(int i = 1 ; i < intervals.length; i++){
            int[] interval = intervals[i];
            if(interval[0] < currEnd){
                // overlap
                count++;
                currEnd = Math.min(currEnd, interval[1]);
            }else{
                currEnd = interval[1];
            }
        }

        return count;
    }
}
