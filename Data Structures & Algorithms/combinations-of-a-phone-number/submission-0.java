class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new ArrayList();
        if (digits.isEmpty()) return res;
        findSubset(0, "", digits, res, map);
        return res;
    }

    void findSubset(int i, String s, String digits, List<String> res, Map<Character, String> map) {
        if (s.length() == digits.length()) {
            res.add(s);
            return;
        }
        for (char c: map.get(digits.charAt(i)).toCharArray()) {
            findSubset(i + 1, s + c, digits, res, map);
        }
    }
}
