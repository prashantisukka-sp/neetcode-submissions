class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, Set<Character>> adj = new HashMap();
      Map<Character, Integer> indeg = new HashMap();
      for (String word: words) {
        for (char c: word.toCharArray()) {
            adj.putIfAbsent(c, new HashSet());
            indeg.putIfAbsent(c, 0);
        }
      }

      for (int i = 0; i < words.length - 1; i++) {
        String s1 = words[i], s2 = words[i + 1];
        int minLen = Math.min(s1.length(), s2.length());
        if (s2.length() < s1.length() && s1.substring(0, minLen).equals(s2.substring(0, minLen))) {
            return "";
        }
        for (int j = 0; j < minLen; j++) {
            if (s1.charAt(j) != s2.charAt(j)) {
                if (!adj.get(s1.charAt(j)).contains(s2.charAt(j))) {
                    adj.get(s1.charAt(j)).add(s2.charAt(j));
                    indeg.put(s2.charAt(j), indeg.get(s2.charAt(j)) + 1);
                }
                break;
            }
        }
      }
      Queue<Character> q = new LinkedList();
      for (char c: indeg.keySet()) {
        if (indeg.get(c) == 0) {
            q.offer(c);
        }
      }
      StringBuilder res = new StringBuilder();
      while (!q.isEmpty()) {
        char c = q.poll();
        res.append(c);
        for (char d: adj.get(c)) {
            indeg.put(d, indeg.get(d) - 1);
            if (indeg.get(d) == 0) {
                q.offer(d);
            }
        }
      }

        if (res.length() == indeg.size()) {
            return res.toString();
        }
        return "";
    }
}
