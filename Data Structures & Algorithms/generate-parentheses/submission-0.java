class Solution {
    Map<Integer, List<String>> memo = new HashMap<>();

    /**
        1 -> ()
        2 -> ()(), (())
        3 -> ()()(), ((())), (()()), ()(()), (())()
        4 -> 

    **/

    Solution() {
        memo = new HashMap<>();
        memo.put(0, List.of());
        memo.put(1, List.of("()"));
    }


    // Duplicates
    public List<String> generateParenthesis(int n) {
        if(memo.containsKey(n)) return memo.get(n);

        Set<String> result = new HashSet<>();
        for(int i = 1; i < n; i++) {
            List<String> left = generateParenthesis(i);
            List<String> right = generateParenthesis(n-i);

            for(String l: left) {
                for(String r: right) {
                    result.add(l+r);
                }
            }
        }

        List<String> n1 = generateParenthesis(n-1);

        for(String s: n1) {
            result.add("(" + s + ")");
        }

        return new ArrayList(result);
    }
}
