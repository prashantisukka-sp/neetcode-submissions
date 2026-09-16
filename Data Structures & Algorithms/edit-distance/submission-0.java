class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.equals(word2)) return 0;
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int[][] cache = new int[w1.length][w2.length];
        for (int[] row: cache) {
            Arrays.fill(row, -1);
        }
        return lcs(0, 0, w1, w2, w1.length, w2.length, cache);
    }
    int lcs(int i, int j, char[] w1, char[] w2, int m, int n, int[][] cache) {
        if (i == m) return n - j;
        if (j == n) return m - i;
        if (cache[i][j] != -1) return cache[i][j];
        if (w1[i] == w2[j]) {
            return lcs(i + 1, j + 1, w1, w2, m, n, cache);
        }
        int cnt = Math.min(lcs(i + 1, j, w1, w2, m, n, cache), lcs(i + 1, j + 1, w1, w2, m, n, cache));
        cnt = Math.min(cnt, lcs(i, j + 1, w1, w2, m, n, cache));
        cache[i][j] = cnt + 1;
        return cache[i][j];
    }
}
