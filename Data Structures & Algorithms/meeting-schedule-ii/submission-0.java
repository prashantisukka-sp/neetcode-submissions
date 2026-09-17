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
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        Queue<Integer> heap = new PriorityQueue();
        for (Interval i: intervals) {
            if (!heap.isEmpty() && heap.peek() <= i.start) {
                heap.poll();
            }
            heap.offer(i.end);
        }
        return heap.size();
    }   
}
