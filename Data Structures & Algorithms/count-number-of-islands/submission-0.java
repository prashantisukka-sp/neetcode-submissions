class Solution {
    public int numIslands(char[][] grid) {
        int r = grid.length, c = grid[0].length, cnt = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    void dfs(char[][] grid, int sr, int sc) {
        int r = grid.length, c = grid[0].length;
        if (sr < 0 || sc < 0 || sr >= r || sc >= c || grid[sr][sc] == '0') {
            return;
        }
        grid[sr][sc] = '0';
        dfs(grid, sr + 1, sc);
        dfs(grid, sr - 1, sc);
        dfs(grid, sr, sc + 1);
        dfs(grid, sr, sc - 1);
    }
}
