class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
       Map<Integer, Integer> map = new HashMap();
       for (int n : nums) {
        map.put(n, map.getOrDefault(n, 0) + 1);
       }
       List<List<Integer>> res = new ArrayList();
       dfs(new ArrayList(), res, map, nums.length);      
       return res; 
    }

    void dfs(List<Integer> temp, List<List<Integer>> res, Map<Integer, Integer> map, int size) {
        if (temp.size() == size) {
            res.add(new ArrayList(temp));
            return;
        }

        for (int n: List.copyOf(map.keySet())) {
            if (map.get(n) > 0) {
                temp.add(n);
                map.put(n, map.get(n) - 1);

                dfs(temp, res, map, size);

                temp.removeLast();
                map.put(n, map.get(n) + 1);
            }
        }

    }
}