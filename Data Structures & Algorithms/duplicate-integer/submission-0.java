class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i< nums.length; i++) {
            int val = nums[i];
            if (map.containsKey(val)) {
                return true;
            }
            map.put(val, 1);
        }
        return false;
    }
}
