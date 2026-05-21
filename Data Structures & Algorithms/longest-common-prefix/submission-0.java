class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        int res = rec(strs, 0);

        if(res == -1) return "";

        return strs[0].substring(0, res+1);
    }

    private int rec(String[] strs, int i) {
        String ref = strs[0];
        for(String s: strs) {
            if(i >= s.length()) return i-1;

            if(s.charAt(i) != ref.charAt(i)) return i-1;
        }

        return rec(strs, i+1);
    }
}