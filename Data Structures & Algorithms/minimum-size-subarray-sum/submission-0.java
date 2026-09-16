class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = Integer.MAX_VALUE;
        int total = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            total += nums[r];
            while (total >= target) {
                len = Math.min(len, r - l + 1);
                total -= nums[l];
                l += 1;
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}