class Solution {
    double dist(int[] a) {
        return Math.sqrt((a[0] * a[0]) + (a[1] * a[1]));
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Double.compare(dist(a), dist(b)));
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
