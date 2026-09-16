class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        int total = 0, cnt = 0;
        for (int i = 0; i < nums.length ; i++) {
            total += nums[i];
            cnt += map.getOrDefault(total - k , 0);
            map.put(total, map.getOrDefault(total, 0) + 1);
        }
        return cnt;
    }
}