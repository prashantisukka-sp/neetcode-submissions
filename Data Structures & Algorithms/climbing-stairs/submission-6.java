public class Solution {
    int[] arr;
    public int climbStairs(int n) {
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = -1;
        }
        return dfs(n, 0);
    }

    public int dfs(int n, int i) {
        if (i >= n) return i == n ? 1 : 0;
        if (arr[i] != -1) return arr[i];
        return arr[i] = dfs(n, i + 1) + dfs(n, i + 2);
    }
}