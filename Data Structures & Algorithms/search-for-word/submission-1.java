class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] used = new boolean[rows][cols];

        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                if(backtrack(board, used,r,c, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean backtrack(char[][] board, boolean[][] used, int r, int c, String word, int i) {
        if(i >= word.length()) return true;
        if(r < 0 || r >= board.length) return false;
        if(c < 0 || c >= board[0].length) return false;
        

        if(used[r][c]) return false;

        if(board[r][c] != word.charAt(i)) return false;
        
        used[r][c] = true;
        
        boolean ans = backtrack(board, used, r+1, c, word, i+1) ||
        backtrack(board, used, r, c+1, word, i+1) ||
        backtrack(board, used, r-1, c, word, i+1) ||
        backtrack(board, used, r, c-1, word, i+1);

        if(ans) return ans;
        used[r][c] = false;
        return false;
    }
}
