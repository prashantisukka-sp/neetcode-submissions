class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";
        int[] indices = new int[2];
        int minLen = Integer.MAX_VALUE, l = 0, have = 0, need = t.length();
        Map<Character, Integer> m1 = new HashMap();
        for (int i = 0; i < need; i++) {
            char c = t.charAt(i);
            m1.put(c, m1.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> m2 = new HashMap();
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            m2.put(c, m2.getOrDefault(c, 0) + 1);
            if (m1.containsKey(c) && m2.get(c) <= m1.get(c)) {
                have++;
            }
            while (have == need) {
                if ((r - l + 1) < minLen) {
                    minLen = r - l + 1;
                    indices[0] = l;
                    indices[1] = r + 1;
                }
                int len = 0;
                char b = s.charAt(l);
                if (m2.get(b) > 1) {
                    len = m2.get(b) - 1;
                    m2.put(b, len);
                } else {
                    m2.remove(b);
                }
                l++;
                if (m1.containsKey(b) && m1.get(b) > len) {
                    have--;                
                }
            }
        }
        return minLen < Integer.MAX_VALUE ? s.substring(indices[0], indices[1]) : "";
    }
}
