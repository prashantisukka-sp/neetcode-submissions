class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int min = 0;
        int[] dp = new int[366];
        int i = 0;
        for (int d = 1; d < 366; d++) {
            dp[d] = dp[d - 1];
            if (i == days.length) return dp[d];
            if (d == days[i]) {
                dp[d] += costs[0];
                dp[d] = Math.min(dp[d], costs[1] + dp[Math.max(0, d - 7)]);
                dp[d] = Math.min(dp[d], costs[2] + dp[Math.max(0, d - 30)]);
                i++;
            }
        }
        return dp[365];
    }
}