class MinStack {

    Stack<Val> stack = new Stack<>();


    public MinStack() {
        
    }
    
    // 1, 100, 50, 1, 25
    public void push(int val) {
        int min = val;

        if(!stack.isEmpty())
        min = Math.min(val, stack.peek().min);

        stack.push(new Val(val, min));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }

    class Val {
        int val;
        int min;

        Val(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }
}
