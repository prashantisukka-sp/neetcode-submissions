class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] cache = new int[str1.length() + 1][str2.length() + 1];
        for (int[] row: cache) {
            Arrays.fill(row, -1);
        }
        lcs(0, 0, str1, str2, cache);
        return buildResponseString(cache, str1, str2);
    }
    String buildResponseString(int[][] cache, String str1, String str2) {
        int i = 0, j = 0, n = str1.length(), m = str2.length();
        StringBuilder sb = new StringBuilder();
        while (i <= n || j <= m) {
            if (i == n) {
                sb.append(str2.substring(j));
                break;
            }
            if (j == m) {
                sb.append(str1.substring(i));
                break;
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                sb.append(str1.charAt(i));
                i++; j++;
            } else if (cache[i + 1][j] < cache[i][j + 1]) {
                sb.append(str1.charAt(i));
                i++;
            } else {
                sb.append(str2.charAt(j));
                j++;
            }
        }
        return sb.toString();
    }
    int lcs(int i, int j, String str1, String str2, int[][] cache) {
        if (cache[i][j] != -1) return cache[i][j];
        if (i == str1.length()) {
            cache[i][j] = str2.length() - j;
            return cache[i][j];
        }
        if (j == str2.length()) {
            cache[i][j] = str1.length() - i;
            return cache[i][j];
        }
        int res = 1;
        if (str1.charAt(i) == str2.charAt(j)) {
            res += lcs(i + 1, j + 1, str1, str2, cache);
        } else {
            res += Math.min(lcs(i + 1, j, str1, str2, cache), lcs(i, j + 1, str1, str2, cache));
        }
        cache[i][j] = res;
        return cache[i][j];
    }
}