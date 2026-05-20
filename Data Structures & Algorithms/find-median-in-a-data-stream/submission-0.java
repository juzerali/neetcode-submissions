class MedianFinder {
    PriorityQueue<Integer> low = new PriorityQueue<>();
    PriorityQueue<Integer> high = new PriorityQueue<>(Collections.reverseOrder());

    // 1 3 5   8 9
    //  high   low
    // 1 3  8 9
    // high low
    public MedianFinder() {
        high.offer(Integer.MIN_VALUE);
        low.offer(Integer.MAX_VALUE);
        
    }
    
    public void addNum(int num) {
        if(num > high.peek() && num < low.peek()) {
            high.offer(num);
            balance();
            return;
        }

        if(num < high.peek()) {
            high.offer(num);
            balance();
        } else {
            low.offer(num);
            balance();
        }        
    }

    public void balance() {
        if(Math.abs(high.size() - low.size()) < 2) return;

        if(high.size() > low.size()) {
            low.offer(high.remove());
        } else {
            high.offer(low.remove());
        }

    }
    
    public double findMedian() {
        if(low.size() == high.size()) {
            return ((double) (low.peek() + high.peek()))/2;
        }

        if(low.size() > high.size()) return low.peek();
        return high.peek();
    }
}
