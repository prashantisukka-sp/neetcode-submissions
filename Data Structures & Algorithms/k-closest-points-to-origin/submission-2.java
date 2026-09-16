class Solution {
    int dist(int[] a) {
        return a[0] * a[0] + a[1] * a[1];
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(dist(a), dist(b)));
        for (int[] point: points) {
            pq.add(point);
        }
        int[][] results = new int[k][2];
        for (int i = 0; i < k; i++) {
            results[i] = pq.poll();
        }
        return results;
    }
}
