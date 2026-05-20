class KthLargest {
    PriorityQueue<Integer> q = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int n: nums) {
            q.offer(n);

            if(q.size() > k) q.remove();
        }
    }
    
    public int add(int val) {
        q.offer(val);
        if(q.size() > k) q.remove();

        return q.peek();
    }
}
