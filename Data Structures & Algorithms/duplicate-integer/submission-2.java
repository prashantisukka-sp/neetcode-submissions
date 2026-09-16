class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            if (map.containsKey(n)) {
                return true;
            }
            map.put(n, 1);
        }
        return false;
    }
}