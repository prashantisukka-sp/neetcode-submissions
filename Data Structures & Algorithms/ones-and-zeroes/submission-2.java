class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int cnt = 0;
        int[][] arr = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            char[] carr = strs[i].toCharArray();
            for (char c: carr) {
                int j = c - '0';
                arr[i][j]++;
            }
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int[] pair: arr) {
            int zeroes = pair[0], ones = pair[1];
            for (int i = m; i >= zeroes; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zeroes][j - ones]);
                }
            }
        }
        return dp[m][n];
    }
}