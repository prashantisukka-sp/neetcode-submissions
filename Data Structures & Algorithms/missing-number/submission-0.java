class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int num = n;
        for (int i = 0; i < n; i++) {
            num ^= i ^ nums[i];
        }
        return num;
    }
}
