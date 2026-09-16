class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int x = nums[0];
        int y = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = y;
            y = Math.max(y, nums[i] + x);
            x = temp;
        }
        return y;
    }
}
