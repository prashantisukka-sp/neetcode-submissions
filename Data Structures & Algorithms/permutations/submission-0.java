class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        res.add(new ArrayList());
        for (int n: nums) {
            List<List<Integer>> itr_res = new ArrayList();
            for (int i = 0; i < res.size(); i++) {
                List<Integer> rtemp = new ArrayList(res.get(i));
                for (int j = 0; j < rtemp.size() + 1; j++) {
                    List<Integer> rtemp2 = new ArrayList(rtemp);
                    rtemp2.add(j, n);
                    itr_res.add(rtemp2);
                }
            }
            res = itr_res;
        }
        return res;
    }
}
