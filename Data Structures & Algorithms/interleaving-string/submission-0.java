class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean[][] cache = new Boolean[s1.length() + 1][s2.length() + 1];
        return lcs(0, 0, 0, s1, s2, s3, cache);
    }
    boolean lcs(int i, int j, int k, String s1, String s2, String s3, Boolean[][] cache) {
        if (k == s3.length()) return i == s1.length() && j == s2.length();
        if (cache[i][j] != null) return cache[i][j];
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            if (lcs(i + 1, j, k + 1, s1, s2, s3, cache)) {
                cache[i][j] = true;
                return true;
            }
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            if (lcs(i, j + 1, k + 1, s1, s2, s3, cache)) {
                cache[i][j] = true;
                return true;
            }
        }
        cache[i][j] = false;
        return false;
    }
}
