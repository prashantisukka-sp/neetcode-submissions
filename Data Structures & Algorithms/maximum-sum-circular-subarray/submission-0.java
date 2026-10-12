class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = nums[0], globalMin= nums[0], total = 0;
        int curSum = 0, curMin = 0;
        for (int i = 0; i < nums.length; i++) {
            curMin = Math.min(curMin, 0) + nums[i];
            curSum = Math.max(curSum, 0) + nums[i];
            total += nums[i];
            globalMin = Math.min(globalMin, curMin);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum > 0 ? Math.max(maxSum, total - globalMin) : maxSum;
    }
}