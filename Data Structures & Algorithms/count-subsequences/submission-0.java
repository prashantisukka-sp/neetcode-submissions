class Solution {
    public int numDistinct(String s, String t) {
        int N = s.length(), M = t.length();
        int[][] cache = new int[N + 1][M + 1];
        for (int[] row: cache) {
            Arrays.fill(row, -1);
        }
        return lcs(0, 0, s.toCharArray(), t.toCharArray(), cache);
    }
    int lcs(int i, int j, char[] s, char[] t, int[][] cache) {
        if (j == t.length) return 1;
        if (i >= s.length) return 0;
        if (cache[i][j] != -1) return cache[i][j];
        int cnt = lcs(i + 1, j, s, t, cache);
        cache[i + 1][j] = cnt;
        if (s[i] == t[j]) {
            int res = lcs(i + 1, j + 1, s, t, cache);
            cache[i + 1][j + 1] = res;
            cnt += res;
        }
        cache[i][j] = cnt;
        return cnt;
    }
}
