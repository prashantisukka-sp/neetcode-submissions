class Solution {
    public String longestPalindrome(String s) {
        int l, r, n = s.length(), len = 0, resL = 0;
        for (int i = 0; i < n; i++) {
            l = i;
            r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > len) {
                    len = r - l + 1;
                    resL = l;
                }
                l--;
                r++;
            }
            l = i;
            r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > len) {
                    len = r - l + 1;
                    resL = l;
                }
                l--;
                r++;
            }
        }
        return s.substring(resL, resL + len);
    }
}
