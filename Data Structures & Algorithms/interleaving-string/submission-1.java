class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();

        if(l3 != l1+l2) return false;

        return isInterleave(s1, s2, s3, 0, 0);
        
    }

    public boolean isInterleave(String s1, String s2, String s3, int i, int j) {
        boolean b1 = i >= s1.length();
        boolean b2 = j >= s2.length();

        if(b1 && b2) return true;

        if(!b1) {
            b1 = s1.charAt(i) == s3.charAt(i+j) && isInterleave(s1, s2, s3, i+1, j);
            if(b1) return b1;
        }

        if(!b2) {
            b2 = s2.charAt(j) == s3.charAt(i+j) && isInterleave(s1, s2, s3, i, j+1);
            if(b2) return b2;
        }
        
        return false;
    }
}
