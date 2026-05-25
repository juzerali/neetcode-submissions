class Solution {
    Map<Integer, Boolean> map = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String word: wordDict) {
            set.add(word);
        }
        return wordBreak(s, 0, set);
    }

    public boolean wordBreak(String s, int start, Set<String> dict) {
        if(start == s.length()) return true;
        if(map.containsKey(start)) return map.get(start);
        boolean has = false;
        for(int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i+1);
            // System.out.println(sub);
            if(dict.contains(sub) && wordBreak(s, i+1, dict)) {
                map.put(start, true);
                return true;
            }
        }

        map.put(start, false);
        return false;
    }
}
