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
        if(intervals.size() <= 1) return true;

        Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);

        Interval prev = intervals.get(0);

        for(int i = 1; i < intervals.size(); i++) {
            if(overlaps(prev, intervals.get(i))) return false;
            prev = intervals.get(i);
        }
        return true;
    }

    boolean overlaps(Interval i1, Interval i2) {
        return i2.start >= i1.start && i2.start < i1.end;
    }
}
