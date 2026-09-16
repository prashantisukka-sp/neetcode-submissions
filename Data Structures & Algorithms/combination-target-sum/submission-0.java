class Solution {
    List<List<Integer>> results = new ArrayList();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        dfs(0, new ArrayList(), nums, 0, target);
        return results;
    }
    void dfs(int i, List<Integer> res, int[] nums, int sum, int target) {
        if (target == sum) {
            results.add(new ArrayList(res));
            return;
        }
        for (int j = i; j < nums.length; j++) {
            if ((sum + nums[j]) > target){
                return;
            }
            res.add(nums[j]);
            dfs(j, res, nums, sum + nums[j], target);
            res.remove(res.size() - 1);
        }
    }
}
