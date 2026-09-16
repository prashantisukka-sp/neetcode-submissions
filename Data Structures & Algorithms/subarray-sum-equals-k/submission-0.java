class Solution {
    public int subarraySum(int[] nums, int k) {
        int cnt = 0;
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        int l = 0, r = 0;
        while (l <= r && r < nums.length) {
            if (prefix[r] - (l == 0 ? 0 : prefix[l - 1]) == k) cnt++;
            if (r == nums.length - 1) {
                l++;
                r = l;
            } else {
                r++;
            }
        }
        return cnt;
    }
}