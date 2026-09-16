class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int totalTime = 0;
        Map<Integer, List<Integer[]>> map = new HashMap();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList());
        }
        for (int[] time: times) {
            map.get(time[0]).add(new Integer[]{time[1], time[2]});
        }

        Map<Integer, Integer> shortest = new HashMap();
        Queue<int[]> q = new PriorityQueue<>((n1, n2) -> n1[0] - n2[0]);
        q.add(new int[]{0, k});
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int w1 = node[0], n1 = node[1];
            if (shortest.containsKey(n1)) {
                continue;
            }
            shortest.put(n1, w1);
            totalTime = w1;
            List<Integer[]> temp = map.get(n1);
            for (int i = 0; i < temp.size(); i++) {
                Integer[] l = temp.get(i);
                int w2 = l[1], n2 = l[0];
                if (!shortest.containsKey(n2)) {
                    q.add(new int[]{w1 + w2, n2});
                }
            }

        }
        return shortest.size() == n ? totalTime : -1;
    }
}
