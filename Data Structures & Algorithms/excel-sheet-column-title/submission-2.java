class Solution {
    public String convertToTitle(int n) {
        if(n==0) return "";
        n--;
        return convertToTitle(n/26) + numToChar(n%26);
    }

    private char numToChar(int n) {
        if (n > 26)
            return 0;

        return (char) ('A' + n);
    }
}