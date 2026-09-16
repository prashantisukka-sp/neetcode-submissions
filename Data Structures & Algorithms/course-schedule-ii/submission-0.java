class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> pre = new HashMap();
        for (int i = 0; i < numCourses; i++) {
            pre.put(i, new ArrayList());
        }
        int[] inDegree = new int[numCourses];
        for (int[] req: prerequisites) {
            inDegree[req[1]]++;
            pre.get(req[0]).add(req[1]);
        }
        Queue<Integer> q = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        int finishedCourses = 0;
        List<Integer> res = new ArrayList();
        while (!q.isEmpty()) {
            int n = q.poll();
            finishedCourses++;
            res.add(n);
            for (int b: pre.get(n)) {
                inDegree[b]--;
                if (inDegree[b] == 0) {
                    q.add(b);
                }
            }
        }
        Collections.reverse(res);
        return (finishedCourses == numCourses ? res : new ArrayList()).stream().mapToInt(Integer::intValue).toArray();
    }
}
