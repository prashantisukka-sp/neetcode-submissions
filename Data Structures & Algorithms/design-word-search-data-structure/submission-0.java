
class WordDictionary {
    List<String> words;

    public WordDictionary() {
        words = new ArrayList();
    }

    public void addWord(String word) {
        words.add(word);
    }

    public boolean search(String word) {
        for (String w: words) {
            if (w.length() != word.length()) continue;
            int i = 0;
            while (i < w.length()) {
                if (w.charAt(i) == word.charAt(i) || word.charAt(i) == '.') {
                    i++;
                } else {
                    break;
                }
            }
            if (i == w.length()) {
                return true;
            }
        }
        return false;
    }
}
