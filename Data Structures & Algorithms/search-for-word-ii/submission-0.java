class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList();
        for (String word: words) {
            char[] c = word.toCharArray();
            if (findWord(c, board)) {
                res.add(word);
            }
        }
        return res;        
    }
    boolean findWord(char[] c, char[][] board) {
        int idx = 0;
        HashSet<String> set = new HashSet();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == c[idx]) {
                    set.add(i + ":" + j);
                    if (isWord(c, board, i, j, idx + 1, set)) {
                        return true;
                    }
                    set.clear();
                }
            }
        }
        return false;   
    }
    boolean isWord(char[] c, char[][] board, int i, int j, int idx, HashSet<String> set) {
        if (c.length == idx) {
            return true;
        }
        boolean found = false;
        if (i < board.length && j < board[0].length - 1 && board[i][j + 1] == c[idx] && set.add(i + ":" + (j + 1))) {
            found = isWord(c, board, i, j + 1, idx + 1, set);
            if (!found) set.remove(i + ":" + (j + 1));
        }
        if (i < board.length - 1 && j < board[0].length && !found && board[i + 1][j] == c[idx] && set.add((i + 1) + ":" + j)) {
            found = isWord(c, board, i + 1, j, idx + 1, set);
            if (!found) set.remove((i + 1) + ":" + j);
        } 
        if (i < board.length && j > 0 && !found && board[i][j - 1] == c[idx] && set.add(i + ":" + (j - 1))) {
            found = isWord(c, board, i, j - 1, idx + 1, set);
            if (!found) set.remove(i + ":" + (j - 1));
        }
        if (i > 0 && j < board[0].length && !found && board[i - 1][j] == c[idx] && set.add((i - 1) + ":" + j)) {
            found = isWord(c, board, i - 1, j, idx + 1, set);
            if (!found) set.remove((i - 1) + ":" + j);
        }        
        return found;
    }
}
