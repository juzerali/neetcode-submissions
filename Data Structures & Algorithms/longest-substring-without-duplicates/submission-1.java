class Solution {
    /**
        a b b a
        0 1 2 x

        i = 3
        li = 0
        start = 2
        ans = 2 (Math.max(ans, i-start+1)

    **/
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        int ans = 0;
        int start = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int lastIndexOf = lastIndex.getOrDefault(c, -1);
            lastIndex.put(c, i);

            if(lastIndexOf != -1) 
            start = Math.max(lastIndexOf + 1, start);
            ans = Math.max(ans, i-start+1);
        }

        return ans;
    }
}
