class MyStack {
    Queue<Integer> q = new LinkedList<>();
    

    public MyStack() {
        
    }
    

    // 1, 2, 3, 4, 5
    public void push(int x) {
        q.offer(x);
    }
    
    public int pop() {
        for(int i = 0; i < q.size()-1; i++) {
            q.offer(q.poll());
        }
        return q.poll();
    }
    
    public int top() {
        int ans = 0;
        for(int i = 0; i < q.size(); i++) {
            ans = q.poll();
            q.offer(ans);
        }
        return ans;
    }
    
    public boolean empty() {
        return q.isEmpty();
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