class Solution {
    public int numDistinct(String s, String t) {
        int M = s.length(), N = t.length();
        int[] dp = new int[N + 1];
        dp[N] = 1;
        for (int i = M - 1; i >= 0; i--) {
            int[] cur = new int[N + 1];
            cur[N] = 1;
            for (int j = N - 1; j >= 0; j--) {
                cur[j] = dp[j];
                if (s.charAt(i) == t.charAt(j)) {
                    cur[j] += dp[j + 1];
                }
            }
            dp = cur;
        }
        return dp[0];
    }
}
