class Solution {
    int[][] matrix;
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;


        this.matrix = matrix;

        int left = 0;
        int right = matrix.length * matrix[0].length -1;

        while(right > left) {
            int mid = (right+left)/2;

            int num = atIndex(mid);
            if(num == target) return true;
            if(num > target) right = mid;
            else left = mid;

            if(right-left == 1) break;
        }
        
        if(atIndex(left) == target || atIndex(right) == target) 
        return true;

        return false;
    }

    int atIndex(int index) {
        int[] coo = cooFromIndex(index);
        return matrix[coo[0]][coo[1]];
    }

    int indexFromCoo(int r, int c) {
        return r*matrix.length + c;
    }

    int[] cooFromIndex(int index) {
        int r = index/matrix[0].length;
        int c = index % matrix[0].length;
        return new int[]{r,c};
    }
}
