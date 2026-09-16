class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList();
        findSubset(1, n, k, new ArrayList(), list);
        return list;
    }
    void findSubset(int i, int n, int k, List<Integer> cur, List<List<Integer>> list) {
        if (cur.size() == k) {
            list.add(new ArrayList(cur));
            return;
        }
        if (i > n) {
            return;
        }
        for (int j = i; j < n + 1; j++) {
            cur.add(j);
            findSubset(j + 1, n, k, cur, list);
            cur.removeLast();
        }
    }
}