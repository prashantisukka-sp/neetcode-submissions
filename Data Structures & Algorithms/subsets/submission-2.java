class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList();
        findSubset(subsets, new ArrayList(), 0, nums);
        return subsets;
    }

    void findSubset(List<List<Integer>> subsets, List<Integer> cur, int i, int[] nums) {
        subsets.add(new ArrayList(cur));
        for (int j = i; j < nums.length; j++) {
            cur.add(nums[j]);
            findSubset(subsets, cur, j + 1, nums);
            cur.removeLast();
        }
    }
}
