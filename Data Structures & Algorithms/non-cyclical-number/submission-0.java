class Solution {
    Set<Integer> memo = new HashSet<>();

    public boolean isHappy(int n) {
        if(n == 1) return true;
        if(n == 0) return false;
        if(memo.contains(n)) return false;
        memo.add(n);

        int square = 0;
        while(n > 0) {
            int digit = n % 10;
            square += digit*digit;
            n /= 10;
        }
        return isHappy(square);
    }
}
