class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList();
        findSubset(nums, 0, new ArrayList(), subsets);
        return subsets;
    }
    void findSubset(int[] nums, int i, List<Integer> cur, List<List<Integer>> subsets) {
        if (i == nums.length) {
            subsets.add(new ArrayList(cur));
            return;
        }
        cur.add(nums[i]);
        findSubset(nums, i + 1, cur, subsets);
        cur.removeLast();
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i += 1;
        }
        findSubset(nums, i + 1, cur, subsets);
    }
}
