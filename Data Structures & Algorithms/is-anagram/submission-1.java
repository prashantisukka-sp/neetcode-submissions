class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (c1[i] == c2[i]) continue;
            map.put(c1[i], map.getOrDefault(c1[i], 0) + 1);
            map.put(c2[i], map.getOrDefault(c2[i], 0) - 1);
        }
        Object[] set = new HashSet<Integer>(map.values()).toArray();
        return set.length == 0 || (set.length == 1 && set[0].equals(0));
    }
}
