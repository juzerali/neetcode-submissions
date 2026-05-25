class Solution {
    public int mySqrt(int x) {
        int l = 0; int r = x;
        int m;

        while(r >= l) {
            m = (r+l)/2;
            long square = (long) m*m;

            if(square == x) return m;

            if(square > x) r = m-1;
            else l = m+1;
        }

        return r;
    }
}