class Union {
    private int[] parent;
    private int[] rank;

    public Union(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    int find(int n) {
        /*if (parent[n] != n) {
            parent[n] = find(parent[n]);
        }
        return parent[n];*/
        int p = parent[n];
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        if (p1 == p2) {
            return false;
        }
        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
        } else if (rank[p1] < rank[p2]) {
            parent[p1] = p2;
        } else {
            parent[p1] = p2;
            rank[p2] += 1;
        }
        return true;
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Union uf = new Union(n);
        
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < n; i++) {
            List<String> str = accounts.get(i);
            int len = str.size();
            for (int j = 1; j < len; j++) {
                String email = str.get(j);
                if (map.containsKey(email)) {
                    uf.union(i, map.get(email));
                } else {
                    map.put(email, i);
                }
            }
        }

        Map<Integer, List<String>> emailMap = new HashMap();
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            String email = entry.getKey();
            int accId = entry.getValue();
            int leader = uf.find(accId);
            emailMap.putIfAbsent(leader, new ArrayList());
            emailMap.get(leader).add(email);
        }

        List<List<String>> res = new ArrayList();
        for (Map.Entry<Integer, List<String>> entry: emailMap.entrySet()) {
            int accId = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> finalList = new ArrayList();
            finalList.add(accounts.get(accId).get(0));
            finalList.addAll(emails);
            res.add(finalList);
        }
        return res;
    }
}