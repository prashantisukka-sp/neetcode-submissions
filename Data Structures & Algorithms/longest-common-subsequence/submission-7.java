class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] cache = new int[text1.length()][text2.length()];
        for (int[] row: cache)
            Arrays.fill(row, -1);
        return dfs(text1.toCharArray(), text2.toCharArray(), 0, 0, cache);
    }
    int dfs(char[] text1, char[] text2, int i1, int i2, int[][] cache) {
        if (i1 == text1.length || i2 == text2.length) {
            return 0;
        }
        if (cache[i1][i2] != -1) {
            return cache[i1][i2];
        }
        if (text1[i1] == text2[i2]) {
            cache[i1][i2] = 1 + dfs(text1, text2, i1 + 1, i2 + 1, cache);
        } else {
            cache[i1][i2] = Math.max(dfs(text1, text2, i1 + 1, i2, cache), dfs(text1, text2, i1, i2 + 1, cache));
        }
        return cache[i1][i2];
    }
}
