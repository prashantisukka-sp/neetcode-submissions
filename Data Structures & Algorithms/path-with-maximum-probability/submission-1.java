class State {
  int node;
  double probability;

  State(int node, double probability)  {
    this.node = node;
    this.probability = probability;
  }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<State>> map = new HashMap();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            map.get(edge[0]).add(new State(edge[1], succProb[i]));
            map.get(edge[1]).add(new State(edge[0], succProb[i]));
        }
        Map<Integer, Double> shortest = new HashMap();
        Queue<State> q = new PriorityQueue<>(Comparator.comparingDouble((State s) -> s.probability).reversed());
        q.add(new State(start_node, 1.0));
        while (!q.isEmpty()) {
            State s = q.poll();
            int nd = s.node;
            double p = s.probability;
            if (shortest.containsKey(nd) && shortest.get(nd) > p) {
                continue;
            }
            shortest.put(nd, p);
            if (nd == end_node) {
                return p;
            }
            List<State> l = map.get(nd);
            for (State temp: l) {
                if (!shortest.containsKey(temp.node)) {
                    q.offer(new State(temp.node, p * temp.probability));
                }
            }
        }
        return 0.0;
    }
}