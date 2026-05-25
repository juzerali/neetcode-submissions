class Solution {
    public int romanToInt(String s) {
        if(s.length() == 0) return 0;

        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()) {
            stack.push(c);
        }

        char prev = stack.pop();
        int sum = toInt(prev);
        while(!stack.isEmpty()) {
            char curr = stack.pop();
            int num = toInt(curr);

            if(curr == 'I') {
                if(prev == 'V' || prev == 'X') {
                    sum -= num;
                } else {
                    sum += num;
                }
            } else if(curr == 'X') {
                if(prev == 'L' || prev == 'C') {
                    sum -= num;
                } else sum += num;
            } else if(curr == 'C') {
                if(prev == 'D' || prev == 'M') {
                    sum -= num;
                } else sum += num;
            } else sum += num;

            prev = curr;
        }

        return sum;
    }

    int toInt(char c) {
        if(c == 'I') return 1;
        if(c == 'V') return 5;
        if(c == 'X') return 10;
        if(c == 'L') return 50;
        if(c == 'C') return 100;
        if(c == 'D') return 500;
        if(c == 'M') return 1000;
        return 0;
    }
}