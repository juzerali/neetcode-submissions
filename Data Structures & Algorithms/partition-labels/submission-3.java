class Solution {

    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        
        if(s.length() == 0) return ans;
        Map<Character, Integer> lastIndex = new LinkedHashMap<>();


        for(int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }

        int size = 0; 
        int end = 0;
        for(int i = 0; i < s.length();i++) {
            size++;

            end = Math.max(end, lastIndex.get(s.charAt(i)));

            if(i == end) {
                ans.add(size);
                size = 0;
            }
        }

        return ans;
    }
}
