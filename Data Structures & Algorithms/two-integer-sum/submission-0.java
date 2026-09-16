class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (map.containsKey(target - val)) {
                result[0] = map.get(target - val);
                result[1] = i;
                break;
            }
            map.put(val, i);
        }
        return result;
    }
}
