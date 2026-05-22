class MyCircularQueue {
    int[] q;
    int front;
    int end;
    
    // [1,2,3,4,5,6,7,8,-,-,-,-,-]
    //  f             e
    // [14,-,-,4,5,6,7,8,9,10,11,12,13]
    //  e      f                        
    public MyCircularQueue(int k) {
        q = new int[k+1];
        front = 0;
        end = 0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        
        q[end++] = value;
        end %= q.length;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;

        int ans = q[front++];
        front %= q.length;
        return true;
    }
    
    public int Front() {
        if(!isEmpty())
        return q[front];

        return -1;
    }
    
    public int Rear() {
        if(isEmpty()) return -1;

        int idx = end-1;
        if(idx == -1) idx = q.length-1;
        return q[idx];
    }
    
    public boolean isEmpty() {
        return front == end;
    }
    
    public boolean isFull() {
        return (end+1)%q.length == front;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */