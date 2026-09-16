class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int cnt = 0;
        int l = 0;
        int sum = 0;
        for (int r = 0; r < arr.length; r++) {
            if ((r - l + 1) > k) {
                sum -= arr[l];
                l += 1;
            }
            sum += arr[r];
            if (r - l + 1 == k && (sum / k) >= threshold) {
                cnt++;
            }
        }
        return cnt;
    }
}