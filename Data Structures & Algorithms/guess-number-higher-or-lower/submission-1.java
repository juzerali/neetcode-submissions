/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1;
        int r = n;

        while(r >= l) {
            int m = (r-l)/2 + l;
            int g = guess(m);

            if(g == 0) return m;

            if(g == -1) r = m-1;
            else l = m+1;
        }

        return -1;
    }
}