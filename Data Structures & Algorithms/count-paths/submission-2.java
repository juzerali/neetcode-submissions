class Solution {
    public int uniquePaths(int m, int n) { //6,3
        if(m < n) return uniquePaths(n,m);

        if(m == 1 || n == 1) return 1;

        int up = m + n - 2; // 7
        int down = n-1; // 5

        long prod = 1;
        int denom = 1;

        for(int i = 0; i < n-1 /* 2 */; i++) {
            prod *= up--; // 7
            prod /= denom++; // 1
        }

        return (int) prod;
    }
}

/**

5.4.1

2.3 2.3

**/
