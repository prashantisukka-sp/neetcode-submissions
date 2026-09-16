class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = nums[0], globalMin = nums[0], total = 0;
        int curSum = 0, curMin = 0;
        for (int n: nums) {
            curSum = Math.max(curSum, 0) + n;
            curMin = Math.min(curMin, 0) + n;
            total += n;
            maxSum = Math.max(maxSum, curSum);
            globalMin = Math.min(curMin, globalMin);
        }
        return maxSum > 0 ? Math.max(maxSum, total - globalMin) : maxSum;
    }
}