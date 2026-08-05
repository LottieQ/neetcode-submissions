/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        PriorityQueue<Interval> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.start, b.start)
        );

        for(Interval interval : intervals){
            pq.offer(interval);
        }

        int prevEnd = -1;
        while(!pq.isEmpty()){
            Interval curr = pq.poll();
            if(curr.start < prevEnd){
                return false;
            }
            prevEnd = curr.end;
        }

        return true;
    }
}
