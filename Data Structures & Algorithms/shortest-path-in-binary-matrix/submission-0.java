class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        int r = grid.length, c = grid[0].length;
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{0, 0, 1});
        boolean[][] visited = new boolean[r][c];
        visited[0][0] = true;
        int res = 0;
        while(!q.isEmpty()) {
            int[] ele = q.poll();
            int sr = ele[0], sc = ele[1], len = ele[2];
            if(sr == r - 1 && sc == c -1) return len;
            int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
            for (int i = 0; i < directions.length; i++) {
                int dr = sr + directions[i][0], dc = sc + directions[i][1];
                if (dr < 0 || dc < 0 || dr >= r || dc >= c || visited[dr][dc] || grid[dr][dc] == 1) {
                    continue;
                }
                visited[dr][dc] = true;
                q.add(new int[] {dr, dc, len + 1});
            }
        }
        return -1;
    }
}