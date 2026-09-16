class Solution {
    public int uniquePaths(int m, int n) {
        int[] prevRow = new int[n];
        int[] curRow = new int[n];
        for (int j = 0; j < n; j++) {
            prevRow[j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                curRow[j] = (j == n - 1 ? 0 : curRow[j + 1]) + prevRow[j];
            }
            prevRow = curRow;
        }
        return prevRow[0];
    }
}
