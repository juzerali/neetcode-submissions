class Solution {
    Set<String> ans;

    public List<String> findWords(char[][] board, String[] words) {
        ans = new HashSet<>();

        int rows = board.length;
        int cols = board[0].length;

        Trie t = new Trie();

        for(String word: words) {
            t.add(word);
            // System.out.println(word + ": " + t.isWord(word));
        }

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                dfs(board, r, c, t, "", new boolean[rows][cols]);
            }
        }

        return new ArrayList<>(ans);
        
    }


    private void dfs(char[][] board, int r, int c, Trie t, String word, boolean[][] seen) {
        // System.out.print(word.length() > 0 ? word : "<>");
        // System.out.println("-" +r +", "+c);
        if(r < 0 || r >= board.length) return;
        if(c < 0 || c >= board[0].length) return;
        if(t == null) return;


        if(seen[r][c]) return;
        seen[r][c] = true;

        t = t.next[board[r][c] - 'a'];

        word = word + board[r][c];
        if(t != null && t.isWord()) {
            // System.out.println("==>" + word);
            ans.add(word);
        }

        
        dfs(board, r-1, c, t, word, seen);
        dfs(board, r+1, c, t, word, seen);
        dfs(board, r, c-1, t, word, seen);
        dfs(board, r, c+1, t, word, seen);
        seen[r][c] = false;

        return;
    } 


    class Trie {
        Trie[] next;
        boolean word;

        Trie() {
            next = new Trie[26];
        }

        public boolean isWord() {
            return word;
        }

        void add(String word) {
            add(word.toCharArray());
        }

        void add(char[] chars) {
            add(chars, 0);
        }

        void add(char[] chars, int i) {
            if(i == chars.length) {
                word = true;
                return;
            }

            if(next[chars[i] -'a'] == null) next[chars[i] -'a'] = new Trie();
            next[chars[i] -'a'].add(chars, i+1);
        }

        boolean isWord(String word) {
            return isWord(word.toCharArray());
        }

        boolean isWord(char[] chars) {
            return isWord(chars, 0);
        }

        boolean isWord(char[] chars, int i) {
            if(i == chars.length) return isWord();
            if(next[chars[i] - 'a'] == null) return false;

            return next[chars[i] -'a'].isWord(chars, i+1);
        }
    }
}
