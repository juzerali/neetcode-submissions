class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> wild = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if(stack.isEmpty() && wild.isEmpty()) return false;
                if(stack.isEmpty()) wild.pop();
                else stack.pop();
            } else {
                wild.push(i);
            }
        }

        if(stack.size() > wild.size()) return false;

        while(!stack.isEmpty()) {
            int open = stack.pop();
            int wld = wild.pop();

            if(open > wld) return false;
        }

        return true;
        
    }

    
}
