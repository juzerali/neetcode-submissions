class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return List.of();
        List<Signature> sigs = new ArrayList<>();
        
        for(String s: strs) sigs.add(new Signature(s));
        Collections.sort(sigs);

        List<List<Signature>> result = new ArrayList<>();
        List<Signature> first = new ArrayList<>();
        first.add(sigs.get(0));
        result.add(first);

        int idx = 0;

        for(int i = 1; i < strs.length; i++) {
            Signature sig = sigs.get(i);

            if(sig.equals(result.get(idx).get(0))) {
                result.get(idx).add(sig);
            } else {
                idx++;
                List<Signature> l = new ArrayList<>();
                l.add(sig);
                result.add(l);
            }
        }

        return result.stream()
            .map(s -> s.stream().map(x -> x.s).collect(Collectors.toList())
        ).collect(Collectors.toList());
        
    }

    static class Signature implements Comparable<Signature> {
        int[] chars;
        String s;

        Signature(String s) {
            this.s = s;
            chars = new int[26];
            
            for(char c : s.toCharArray()) {
                chars[c-'a']++;
            }
        }

        public int compareTo(Signature that) {
            int hash = 0;

            for(int i = 0; i < 26; i++) {
                if(this.chars[i] != that.chars[i])
                return this.chars[i] - that.chars[i];
            }
            return hash;
        }

        public boolean equals(Object o) {
            if (o instanceof Signature s) {
                for(int i = 0; i < 26; i++) {
                    if(this.chars[i] != s.chars[i]) return false;
                }
                return true;
            }
            return false;
        }
    }
}
