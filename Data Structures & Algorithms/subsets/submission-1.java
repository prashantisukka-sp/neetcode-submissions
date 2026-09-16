class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList();
        findSubset(subsets, new ArrayList(), 0, nums);
        return subsets;
    }

    void findSubset(List<List<Integer>> subsets, List<Integer> cur, int i, int[] nums) {
        if (i == nums.length) {
            subsets.add(new ArrayList(cur));
            return;
        }
        cur.add(nums[i]);
        findSubset(subsets, cur, i + 1, nums);
        cur.removeLast();
        findSubset(subsets, cur, i + 1, nums);
    }
}
