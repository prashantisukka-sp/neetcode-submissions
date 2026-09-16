class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet();
        for (int n: nums) {
            set.add(n);
        }
        int res = 1;
        for (int n: nums) {
            if (!set.contains(n - 1)) {
                res = Math.max(res, fetchSequence(set, n));
            }
        }
        return res;
    }

    int fetchSequence(HashSet<Integer> set, int n) {
        int cnt = 1;
        while (set.contains(n + cnt)) { cnt++; }
        return cnt;
    }
}
