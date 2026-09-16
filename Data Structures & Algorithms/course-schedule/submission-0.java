class Solution {
    Map<Integer, List<Integer>> map = new HashMap();
    List<Integer> visited = new ArrayList();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) return true;
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return false;
        }
        return true;
    }
    boolean dfs(int course) {
        if (visited.contains(course)) {
            return false;
        }
        if (map.get(course).size() == 0) {
            return true;
        }
        visited.add(course);
        for (int cr: map.get(course)) {
            if (!dfs(cr)) return false;
        }
        visited.remove(Integer.valueOf(course));
        map.put(course, new ArrayList());
        return true;
    }
}
