class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int N = text1.length(), M = text2.length();
        int[] prevRow = new int[M + 1];
        for (int i = N - 1; i >= 0; i--) {
            int[] curRow = new int[M + 1];
            for (int j = M - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j))
                    curRow[j] = 1 + prevRow[j + 1];
                else 
                    curRow[j] = Math.max(prevRow[j], curRow[j + 1]);
            }
            prevRow = curRow;
        }
        return prevRow[0];
    }
}
