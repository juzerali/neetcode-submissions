class Solution {
    public String convertToTitle(int n) {
        String ans = "";

        while(n > 0) {
            if(n == 26) {
                ans = 'Z' + ans;
                break;
            } else {
                int mod = n % 26;
                ans = numToChar(mod) + ans;
                n -= mod;
            }
            n /= 26;
        }
        return ans;
    }

    private char numToChar(int n) {
        if(n > 26) return 0;
        if(n == 26) return 'Z';

        return (char) ('A' + n - 1);
    }
}