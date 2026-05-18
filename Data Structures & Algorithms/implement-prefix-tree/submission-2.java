class PrefixTree {
    boolean ends = false;
    PrefixTree[] inner = new PrefixTree[26];

    public PrefixTree() {
        inner = new PrefixTree[26];
    }

    public void insert(String word) {
        insert(word.toCharArray(), 0);
    }

    private void insert(char[] word, int ind) {
        if(ind == word.length) {
            this.ends = true;
            return;
        }

        int i = nextIndex(word, ind);

        if(inner[i] == null) inner[i] = new PrefixTree();
        inner[i].insert(word, ind+1);
    }

    public boolean search(String word) {
        return search(word.toCharArray(), 0);

    }

    public boolean search(char[] word, int ind) {
        if(word.length == ind) {
            return this.ends;
        }
        int i = nextIndex(word, ind);

        if(inner[i] == null) return false;

        return this.inner[i].search(word, ind+1);

    }

    public boolean startsWith(String prefix) {
        return startsWith(prefix.toCharArray(), 0);
    }

    public boolean startsWith(char[] prefix, int ind) {
        if(prefix.length == ind) return true;
        int i = nextIndex(prefix, ind);

        if(inner[i] == null) return false;

        return inner[i].startsWith(prefix, ind+1);
    }

    private int index(char c) {
        return c - 'a';
    }

    private int nextIndex(String word) {
        return index(word.charAt(0));
    }

    private int nextIndex(char[] word) {
        return index(word[0]);
    }

    private int nextIndex(char[] word, int i) {
        return index(word[i]);
    }
}
