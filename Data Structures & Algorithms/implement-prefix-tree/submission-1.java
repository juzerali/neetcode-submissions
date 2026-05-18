class PrefixTree {
    boolean ends = false;
    PrefixTree[] inner = new PrefixTree[26];

    public PrefixTree() {
        inner = new PrefixTree[26];
    }

    public void insert(String word) {
        if(word.length() == 0) {
            this.ends = true;
            return;
        }

        int i = nextIndex(word);

        if(inner[i] == null) inner[i] = new PrefixTree();
        inner[i].insert(word.substring(1));
    }

    public boolean search(String word) {
        if(word.length() == 0) {
            return this.ends;
        }
        int i = nextIndex(word);

        if(inner[i] == null) return false;

        return this.inner[i].search(word.substring(1));

    }

    public boolean startsWith(String prefix) {
        if(prefix.length() == 0) return true;
        int i = nextIndex(prefix);

        if(inner[i] == null) return false;

        return inner[i].startsWith(prefix.substring(1));
    }

    private int index(char c) {
        return c - 'a';
    }

    private int nextIndex(String word) {
        return index(word.charAt(0));
    }
}
