class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l = 0;
        HashSet<Integer> set = new HashSet();
        set.add(nums[0]);
        for (int r = 1; r < nums.length; r++) {
            if ((r - l) > k) {
                set.remove(nums[l]);
                l += 1;
            }
            if (!set.add(nums[r])) {
                return true;
            }
        }
        return false;
    }
}