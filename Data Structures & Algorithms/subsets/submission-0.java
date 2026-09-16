class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        res.add(new ArrayList());
        for (int n: nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> s = new ArrayList(res.get(i));
                s.add(n);
                res.add(s);
            }
        }
        return res;
    }
}
