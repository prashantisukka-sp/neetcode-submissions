class Solution {
    public boolean checkInclusion(String s1, String s2) {
       boolean perm = false;
       char[] c1 = s1.toCharArray();
       Arrays.sort(c1);
       String sortedS1 = new String(c1);
       for (int i = 0; i < s2.length(); i++) {
        char c = s2.charAt(i);
        if (sortedS1.indexOf(c) != -1 && (i + sortedS1.length()) <= s2.length()) {
            char[] c2 = s2.substring(i, i + sortedS1.length()).toCharArray();
            Arrays.sort(c2);
            String sortedS2 = new String(c2);
            if (sortedS1.equals(sortedS2)) {
                perm = true;
                break;
            }       
        }
       }
       return perm; 
    }
}
