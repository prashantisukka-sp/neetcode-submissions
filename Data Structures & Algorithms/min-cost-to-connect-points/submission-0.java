class Solution {
    public int minCostConnectPoints(int[][] points) {
        int edges = 0, node = 0, minCost = 0, n = points.length;
        boolean[] visit = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        while (edges < n - 1) {
            visit[node] = true;
            int nextNode = -1;
            for (int i = 0; i < n; i++) {
                if (visit[i] == true) continue;
                int curDist = Math.abs(points[i][0] - points[node][0]) + Math.abs(points[i][1] - points[node][1]);
                dist[i] = Math.min(dist[i], curDist);
                if (nextNode == -1 || dist[i] < dist[nextNode]) {
                    nextNode = i;
                }
            }
            minCost += dist[nextNode];
            node = nextNode;
            edges++;
        }
        return minCost;
    }
}
