class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l = 0;
        HashSet<Integer> set = new HashSet();
        for (int r = 0; r < nums.length; r++) {
            if ((r - l) > k) {
                set.remove(nums[l]);
                l += 1;
            }
            if (set.contains(nums[r])) {
                return true;
            }
            set.add(nums[r]);
        }
        return false;
    }
}