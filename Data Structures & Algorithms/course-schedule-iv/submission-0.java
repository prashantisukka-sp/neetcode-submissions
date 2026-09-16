class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> res = new ArrayList();
        List<Set<Integer>> map = new ArrayList();
        List<Set<Integer>> pre = new ArrayList();
        int[] indeg = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            map.add(new HashSet());
            pre.add(new HashSet());
        }
        for (int[] req: prerequisites) {
            map.get(req[0]).add(req[1]);
            indeg[req[1]]++;
        }
        Queue<Integer> q = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int c = q.poll();
            for (int n: map.get(c)) {
                pre.get(n).add(c);
                pre.get(n).addAll(pre.get(c));
                indeg[n]--;
                if (indeg[n] == 0) {
                    q.offer(n);
                }
            }
        }
        for (int[] query: queries) {
            res.add(pre.get(query[1]).contains(query[0]));
        }
        return res;
    }
}