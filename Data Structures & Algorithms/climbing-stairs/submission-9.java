class Solution {
    public int climbStairs(int n) {
        int x = 1, y = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = y;
            y = y + x;
            x = tmp;
        }
        return y;
    }
}
