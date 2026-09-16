class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1)
                maxArea = Math.max(findArea(grid, i, j, 0), maxArea);
            }
        }
        return maxArea;
    }
    int findArea(int[][] grid, int sr, int sc, int cnt) {
        int r = grid.length, c = grid[0].length;
        if (sr < 0 || sc < 0|| sr >= r || sc >= c || grid[sr][sc] == 0) {
            return cnt;
        }
        grid[sr][sc] = 0;
        cnt++;
        cnt += findArea(grid, sr + 1, sc, 0);
        cnt += findArea(grid, sr - 1, sc, 0);
        cnt += findArea(grid, sr, sc + 1, 0);
        cnt += findArea(grid, sr, sc - 1, 0);
        return cnt;
    }
}
