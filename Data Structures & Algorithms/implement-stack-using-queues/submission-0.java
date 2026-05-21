class MyStack {
    int[] q = new int[5000];
    int pointer = -1;
    

    public MyStack() {
        
    }
    
    public void push(int x) {
        q[++pointer] = x;
    }
    
    public int pop() {
        return q[pointer--];
    }
    
    public int top() {
        return q[pointer];
    }
    
    public boolean empty() {
        return pointer == -1;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */