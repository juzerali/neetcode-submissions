class Solution {
    int[][] matrix;
    int n;

    public void rotate(int[][] matrix) {
        this.matrix = matrix;
        n = matrix.length;

        for(int i = 0; i < n/2; i++) {
            int j = n-i-1;
            int[] temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;
        }

        for(int r = 0; r < n; r++) {
            for(int c = r; c < n; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }

    }

}
