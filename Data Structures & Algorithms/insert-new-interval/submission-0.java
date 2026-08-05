class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        while(i < n && intervals[i][1] < newInterval[0]){
            ans.add(intervals[i]);
            i++;
        }

        int newStart = newInterval[0], newEnd = newInterval[1];
        
        while(i < n && intervals[i][0] <= newInterval[1]){
            newStart = Math.min(intervals[i][0], newStart);
            newEnd = Math.max(intervals[i][1], newEnd);
            i++;
        }

        ans.add(new int[]{newStart, newEnd});

        while(i < n){
            ans.add(intervals[i]);
            i++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
