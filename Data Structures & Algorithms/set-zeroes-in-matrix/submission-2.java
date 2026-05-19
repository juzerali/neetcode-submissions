class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(matrix[r][c] == 0) all(matrix, r, c);
            }
        }

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(matrix[r][c] == -1) matrix[r][c] = 0;
            }
        }
    }

    void all(int[][] matrix, int r, int c) {
        left(matrix, r, c);
        right(matrix, r, c);
        up(matrix, r, c);
        down(matrix, r, c);
    }

    void left(int[][] matrix, int r, int c) {
        for(int i = c-1; i >= 0; i-- ) {
            if(matrix[r][i] != 0) matrix[r][i] = -1;
        }
    }

    void right(int[][] matrix, int r, int c) {
        for(int i = c+1; i < matrix[0].length; i++ ) {
            if(matrix[r][i] != 0) matrix[r][i] = -1;
        }
    }

    void up(int[][] matrix, int r, int c) {
        for(int i = r-1; i >= 0; i-- ) {
            if(matrix[i][c] != 0) matrix[i][c] = -1;
        }
    }

    void down(int[][] matrix, int r, int c) {
        for(int i = r+1; i < matrix.length; i++ ) {
            if(matrix[i][c] != 0) matrix[i][c] = -1;
        }
    }
}
