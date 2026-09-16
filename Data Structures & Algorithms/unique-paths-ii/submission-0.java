class Solution {
    int[][] cache;
    int m, n;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cache[i][j] = -1;
            }
        }
        return dfs(0, 0, obstacleGrid);
    }
    int dfs(int r, int c, int[][] obstacleGrid) {
        if (r == m || c == n) {
            return 0;
        }
        if (obstacleGrid[r][c] == 1) {
            cache[r][c] = 0;
            return 0;
        }
        if (r == m - 1 && c == n - 1) {
            cache[r][c] = 1;
            return 1;
        }
        if (cache[r][c] > -1) {
            return cache[r][c];
        }
        cache[r][c] = dfs(r + 1, c, obstacleGrid) + dfs(r, c + 1, obstacleGrid);
        return cache[r][c];
    }
}