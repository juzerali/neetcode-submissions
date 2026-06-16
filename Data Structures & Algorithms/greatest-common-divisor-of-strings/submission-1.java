class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() > str2.length())
            return gcdOfStrings(str2, str1);

        String ans = "";
        for(int i = 0; i < str1.length(); i++) {
            String sub = str1.substring(0, i+1);
            if(divides(str1, sub) && divides(str2, sub)) ans = sub;
        }
        return ans;
    }

    public boolean divides(String s, String t) {
        int j = 0;
        for (int i = 0; i < s.length(); i++,j++) {
            if(j == t.length()) j = 0;
            if (s.charAt(i) != t.charAt(j))
                return false;
            
        }

        return j == 0 || j == t.length();
    }
}