class Solution {

    boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public int calculate(String s) {
        char[] tokens = s.toCharArray();

        int num = 0;
        int prev = 0;
        int total = 0;
        char op = '+';

        for(int i = 0; i <= tokens.length; i++) {
            char token = i == tokens.length ? '+' : tokens[i];

            if(token == ' ') continue;

            if(Character.isDigit(token)) {
                num = num*10 + (token-'0');
            }

            if(!Character.isDigit(token) || i >= tokens.length-1) {
                if(op == '+') {
                    total += prev;
                    prev = num;
                } else if(op == '-') {
                    total += prev;
                    prev = -num;
                } else if(op == '*') {
                    prev *= num;
                } else if(op == '/') {
                    prev /= num;
                }

                num = 0;
                op = token;
            }
        }

        total += prev;
        return total;
    }

    
}