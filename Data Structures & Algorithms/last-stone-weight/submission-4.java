class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue(Collections.reverseOrder());
        for (int n: stones) {
            q.add(n);
        }
        while (q.size() > 1) {
            int x = q.poll();
            int y = q.poll();
            q.add(Math.abs(x - y));
        }
        return q.isEmpty() ? 0 : q.peek();
    }
}
