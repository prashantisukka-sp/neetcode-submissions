class Solution {
    Map<Integer, Integer> map = new HashMap();
    public int climbStairs(int n) {
        return dfs(0, n);
    }
    int dfs(int i, int n) {
        if (i == n) return 1;
        if (i > n) return 0;
        if (!map.containsKey(i)) {
            map.put(i, dfs(i + 1, n) + dfs (i + 2, n));
        }
        return map.get(i);
    }
}
