class NumMatrix {
    int[][] prefix_sum;

    public NumMatrix(int[][] matrix) {
        prefix_sum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            int total = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                total += matrix[i][j];
                prefix_sum[i + 1][j + 1] = total + prefix_sum[i][j + 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row2++;
        row1++;
        col1++;
        col2++;
        return prefix_sum[row2][col2] - prefix_sum[row1 - 1][col2] - prefix_sum[row2][col1 - 1] + prefix_sum[row1 - 1][col1 - 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */