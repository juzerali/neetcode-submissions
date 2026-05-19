class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(String t: tokens) {
            if(t.equals("+")) {
                stack.push(
                    stack.pop() + stack.pop()
                );
            } else if(t.equals("-")) {
                stack.push(-(stack.pop() - stack.pop()));
            } else if(t.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if(t.equals("/")) {
                int divisor = stack.pop();
                stack.push(
                    stack.pop() / divisor
                );
            } else {
                int v = Integer.parseInt(t);
                stack.push(v);
            }
        }

        return stack.pop();
        
    }
}
