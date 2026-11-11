class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = amount + 1;
        }
        for (int c: coins) {
            for (int j = c; j <= amount; j++) {
                dp[j] = Math.min(dp[j], 1 + dp[j - c]);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
