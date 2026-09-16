class Solution {
    public int orangesRotting(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int res = 0, fresh = 0;
        Queue<int[]> q = new LinkedList();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) fresh++;
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }
        while (fresh > 0 && !q.isEmpty()) {
            res++;
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int[] ele = q.poll();
                int dr = ele[0], dc = ele[1];
                int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                for (int i = 0; i < directions.length; i++) {
                    int sr = dr + directions[i][0], sc = dc + directions[i][1];
                    if (sr >= 0 && sc >= 0 && sr < r && sc < c && grid[sr][sc] == 1) {
                        grid[sr][sc] = 2;
                        q.add(new int[]{sr, sc});
                        fresh--;
                    }
                }
            }
        }
        return fresh == 0 ? res : -1;
    }
}
