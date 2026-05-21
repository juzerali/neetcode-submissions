class Solution {
    public String decodeString(String s) {
        return decodeString(s, 0).toString();
    }

    public StringBuilder decodeString(String s, int i) {
        int number = 0;
        Stack<Wrapper> stack = new Stack<>();
        stack.push(new Wrapper(new StringBuilder(), 1));
        
        for(; i < s.length(); i++) {
            char c = s.charAt(i);

            if(isAlpha(c)) {
                stack.peek().s.append(c);
            } else if(isNumber(c)) {
                int n = getNumber(c);
                number = number*10 + n;
            } else if(isOpen(c)) {
                stack.push(new Wrapper(new StringBuilder(), number));
                number = 0;
            } else if(isClose(c)) {
                Wrapper w = stack.pop();
                for(int j = 0; j < w.times; j++) 
                stack.peek().s.append(w.s);
            }
        }

        StringBuilder b = new StringBuilder();
        
        System.out.println(stack.size());
        return stack.peek().s;
    }

    private class Wrapper {
        StringBuilder s;
        int times;

        Wrapper(StringBuilder s, int times) {
            this.s = s;
            this.times = times;
        }
    }

    boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    boolean isAlpha(char c) {
        return c >= 'a' && c <= 'z';
    }

    boolean isOpen(char c) {
        return c == '[';
    }

    boolean isClose(char c) {
        return c >= ']';
    }

    int getNumber(char c) {
        return c - '0';
    }
}