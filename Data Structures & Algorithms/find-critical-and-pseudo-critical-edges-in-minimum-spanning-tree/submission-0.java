class UnionFind {
    int n;
    int[] parent;
    int[] rank;

    UnionFind(int n) {
        this.n = n;
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    int find(int n1) {
        if (n1 != parent[n1]) {
            parent[n1] = find(parent[n1]);
        }
        return parent[n1];
    }

    boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        if (p1 == p2) return false;
        n--;
        if (rank[p1] < rank[p2]) {
            int temp = p2;
            p2 = p1;
            p1 = temp;
        }
        parent[p2] = p1;
        rank[p1] = rank[p1] + rank[p2];        
        return true;
    }

    boolean isConnected() {
        return n == 1;
    }
}
class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            edges[i] = Arrays.copyOf(edges[i], edges[i].length + 1);
            edges[i][3] = i;
        }
        Arrays.sort(edges, Comparator.comparingInt(i -> i[2]));
        List<Integer> critical = new ArrayList();
        List<Integer> pseudo = new ArrayList();
        int mst_wt = findMSTWeight(n, edges, -1, false);
        for (int i = 0; i < edges.length; i++) {
            if (mst_wt < findMSTWeight(n, edges, i, false)) {
                critical.add(edges[i][3]);
            } else if (mst_wt == findMSTWeight(n, edges, i, true)) {
                pseudo.add(edges[i][3]);
            }
        }
        return Arrays.asList(critical, pseudo);        
    }
    int findMSTWeight(int n, int[][] edges, int index, boolean include) {
        int wt = 0;
        UnionFind uf = new UnionFind(n);
        if (include) {
            wt += edges[index][2];
            uf.union(edges[index][0], edges[index][1]);
        }
        for (int i = 0; i < edges.length; i++) {
            if (i == index) continue;
            if (uf.union(edges[i][0], edges[i][1])) {
                wt += edges[i][2];
            }
        }
        return uf.isConnected() ? wt : Integer.MAX_VALUE;
    }
}