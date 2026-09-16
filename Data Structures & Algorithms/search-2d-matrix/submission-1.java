class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int cols = matrix.length;
        int low = 0; 
        int high = matrix.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            int len = matrix[mid].length - 1;
            if (target >= matrix[mid][0] && target <= matrix[mid][len]) {
                break;
            }
            if (target < matrix[mid][0]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (!(low <= high)) return false;
        low = 0; high = matrix[mid].length - 1;
        while (low <= high) {
            int m = low + (high - low) / 2;
            if (target == matrix[mid][m]) {
                return true;
            } 
            if (target > matrix[mid][m]) {
                low = m + 1;
            } else {
                high = m - 1;
            }
        }
        return false;
    }
}
