class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefix = new int[nums.length + 2];
        int total = 0, idx = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            prefix[i + 1] = total;
        }
        for (int i = 1; i < nums.length + 1; i++) {
            if (prefix[i - 1] == total - prefix[i]) {
                idx = Math.min(idx, i - 1);
            }
        }
        return idx == Integer.MAX_VALUE ? -1 : idx;
    }
}