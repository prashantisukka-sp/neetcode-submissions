class Solution {
    public int[] countBits(int n) {
        int[] bitCounts = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            bitCounts[i] = count(i);
        }
        return bitCounts;
    }
    int count(int n) {
        int cnt = 0;
        while (n != 0) {
            if ((n & 1) == 1) cnt++;
            n = n >> 1;
        }
        return cnt;
    }
}
