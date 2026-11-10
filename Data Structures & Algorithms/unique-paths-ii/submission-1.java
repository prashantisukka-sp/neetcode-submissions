class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] prevRow = new int[n];
        for (int i = m - 1; i >= 0; i--) {
            int[] curRow = new int[n];
            for (int j = n - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    curRow[j] = 0;
                } else if (i == m - 1 && j == n - 1) {
                    curRow[j] = 1;
                } else {
                    curRow[j] = (j + 1 < n ? curRow[j + 1] : 0) + prevRow[j];
                }
            }
            prevRow = curRow;
        }
        return prevRow[0];
    }
}