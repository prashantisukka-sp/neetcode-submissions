class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i< nums.length; i++) {
            int val = nums[i];
            if (set.contains(val)) {
                return true;
            }
            set.add(val);
        }
        return false;
    }
}
