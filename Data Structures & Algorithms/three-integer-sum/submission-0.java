class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0 || (i > 0 && nums[i] == nums[i - 1])) continue;
            int val = nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = val + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(val, nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }
}
