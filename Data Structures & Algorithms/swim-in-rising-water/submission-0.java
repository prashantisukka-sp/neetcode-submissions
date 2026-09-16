class Solution {
    public int swimInWater(int[][] grid) {
        int time = 0;
        int N = grid.length;
        boolean[][] visit = new boolean[N][N];
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        q.offer(new int[] {grid[0][0], 0, 0});
        visit[0][0] = true;
        while (!q.isEmpty()) {
            int[] data = q.poll();
            int val = data[0], r = data[1], c = data[2];
            if (r == N - 1 && c == N - 1) {
                return val;
            }
            for (int[] d: dir) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visit[nr][nc]) {
                    visit[nr][nc] = true;
                    q.offer(new int[] {Math.max(val, grid[nr][nc]), nr, nc});
                }
            }
        }
        return N * N;
    }
}
