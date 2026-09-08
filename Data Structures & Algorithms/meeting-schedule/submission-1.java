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
        // sort meeting intervals based of start time.
        intervals.sort(Comparator.comparing(interval -> interval.start));

        // Number of meetings
        int n = intervals.size();

        // base case if only one meeting then return true as there will be no conflicts
        if (n <= 1) {
            return true;
        }
        for (int i = 1; i < n; i++) {
            if (intervals.get(i - 1).end > intervals.get(i).start)
                return false;
        }
        return true;
    }
}
